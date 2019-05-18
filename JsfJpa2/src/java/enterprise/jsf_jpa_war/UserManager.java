package enterprise.jsf_jpa_war;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 * <p>
 * A simple managed bean to mediate between the user and the persistence
 * layer.</p>
 *
 * @author rlubke
 */
public class UserManager {

    /**
     * <p>
     * The key for the session scoped attribute holding the appropriate
     * <code>Wuser</code> instance.</p>
     */
    public static final String USER_SESSION_KEY = "user";

    /**
     * <p>
     * The <code>PersistenceContext</code>.</p>
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * <p>
     * The transaction resource.</p>
     */
    @Resource
    private UserTransaction utx;

    /**
     * <p>
     * User properties.</p>
     */
    private String username;
    private String password;
    private String passwordv;
    private String fname;
    private String lname;

    // -------------------------------------------------------------- Properties
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordv() {
        return passwordv;
    }

    public void setPasswordv(String passwordv) {
        this.passwordv = passwordv;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * <p>
     * Validates the user. If the user doesn't exist or the password is
     * incorrect, the appropriate message is added to the current
     * <code>FacesContext</code>. If the user successfully authenticates,
     * navigate them to the page referenced by the outcome
     * <code>app-main</code>.
     * </p>
     *
     * @return <code>app-main</code> if the user authenticates, otherwise
     * returns <code>null</code>
     */
    public String validateUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        Wuser user = getUser();
        if (user != null) {
            if (!user.getPassword().equals(password)) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Login Failed!",
                        "A senha especificada não está correta.");
                context.addMessage(null, message);
                return null;
            }

            context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
            return "app-main";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Login Failed!",
                    "Username '"
                    + username
                    + "' não existe.");
            context.addMessage(null, message);
            return null;
        }
    }
    
    public String listUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        List<Wuser> users = getUsers();
        if (users != null) {
            context.getExternalContext().getSessionMap().put("users", users);
            return "list";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Retorno vazio","!");
            context.addMessage(null, message);
            return null;
        }
    }

    /**
     * <p>
     * Creates a new <code>Wuser</code>. If the specified user name exists or an
     * error occurs when persisting the Wuser instance, enqueue a message
     * detailing the problem to the <code>FacesContext</code>. If the user is
     * created, move the user back to the login view.</p>
     *
     * @return <code>login</code> if the user is created, otherwise returns
     * <code>null</code>
     */
    public String createUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        Wuser wuser = getUser();
        if (wuser == null) {
            if (!password.equals(passwordv)) {
                FacesMessage message = new FacesMessage("As senhas não coincidem.  Tente novamente");
                context.addMessage(null, message);
                return null;
            }
            wuser = new Wuser();
            wuser.setFirstname(fname);
            wuser.setLastname(lname);
            wuser.setPassword(password);
            wuser.setUsername(username);
            wuser.setSince(new Date());
            try {
                utx.begin();
                em.persist(wuser);
                utx.commit();
                return "login";
            } catch (Exception e) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Erro ao criar usuário!",
                        "Erro inesperado ao criar usuário.  Por favor contate o Administrador do Sistema");
                context.addMessage(null, message);
                Logger.getAnonymousLogger().log(Level.SEVERE,
                        "Não foi possivel criar um novo usuário",
                        e);
                return null;
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Usuário '"
                    + username
                    + "' já existe!  ",
                    "Escolha um outro nome de usuário.");
            context.addMessage(null, message);
            return null;
        }
    }
    
    /**
     * <p>
     * When invoked, it will invalidate the user's session and move them to the
     * login view.</p>
     *
     * @return <code>login</code>
     */
    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "login";

    }

    // --------------------------------------------------------- Private Methods
    /**
     * <p>
     * This will attempt to lookup a <code>Wuser</code> object based on the
     * provided user name.</p>
     *
     * @return a <code>Wuser</code> object associated with the current username,
     * otherwise, if no <code>Wuser</code> can be found, returns
     * <code>null</code>
     */
    private Wuser getUser() {
        try {
            Wuser user = (Wuser) em.createNamedQuery("Wuser.findByUsername").
                    setParameter("username", username).getSingleResult();
            return user;
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    private List<Wuser> getUsers() {
        try {
            List<Wuser> users = new ArrayList<Wuser>();
            for(Object user : em.createNamedQuery("Wuser.findAll").setParameter("id", 0).getResultList()){
                users.add((Wuser)user);
            }
            return users;
        } catch (NoResultException nre) {
            return new ArrayList<Wuser>();
        }
    }

}
