
import formation.metier.Infos;
import java.util.HashSet;
import java.util.Set;

public class FormateurSingleton {

    protected int idform;
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected int cp;
    protected String localite;
    protected String rue;
    protected String num;
    protected String tel;
    protected Set<Infos> mesInfos = new HashSet<>();

    private FormateurSingleton(FormateurBuilder cb) {
        this.idform = cb.idform;
        this.matricule = cb.matricule;
        this.nom = cb.nom;
        this.prenom = cb.prenom;
        this.cp = cb.cp;
        this.localite = cb.localite;
        this.rue = cb.rue;
        this.num = cb.num;
        this.tel = cb.tel;
    }

    public int getIdclient() {
        return idform;
    }
//tousles getters mais aucun setter

    public static class FormateurBuilder {

        protected int idform;
        protected String matricule;
        protected String nom;
        protected String prenom;
        protected int cp;
        protected String localite;
        protected String rue;
        protected String num;
        protected String tel;

        public FormateurBuilder setIdform(int idform) {
            this.idform = idform;
            return this;
        }

        public FormateurBuilder setMatricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public FormateurBuilder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public FormateurBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public FormateurBuilder setCp(int cp) {
            this.cp = cp;
            return this;
        }

        public FormateurBuilder setLocalite(String localite) {
            this.localite = localite;
            return this;
        }

        public FormateurBuilder setRue(String rue) {
            this.rue = rue;
            return this;
        }

        public FormateurBuilder setNum(String num) {
            this.num = num;
            return this;
        }

        public FormateurBuilder setTel(String tel) {
            this.tel = tel;
            return this;
        }

        public FormateurSingleton build() throws Exception {
            if (idform <= 0 || nom == null || prenom == null || matricule == null) {
                throw new Exception("informations de construction incomplètes");
            }
            return new FormateurSingleton(this);
        }
    }

    @Override
    public String toString() {
        return "Formateur{" + "idform=" + idform + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", cp=" + cp + ", localite=" + localite + ", rue=" + rue + ", num=" + num + ", tel=" + tel + ", mesInfos=" + mesInfos + '}';
    }
    
    

    public static void main(String[] args) {
        try {
            FormateurSingleton fm1 = new FormateurSingleton.FormateurBuilder().
                    setIdform(1).
                    setNom("Durant").
                    setPrenom("Eric").
                    setMatricule("SBB-634").
                    setTel("0455/332211").
                    setLocalite("Mons").
                    build();
            System.out.println(fm1);
        } catch (Exception e) {
            System.out.println("erreur " + e);
        }
        try {
            FormateurSingleton fm2 = new FormateurSingleton.FormateurBuilder().
                    setIdform(1).
                    setNom("Durant").
                    setPrenom("Eric").
                    setLocalite("Mons").
                    build();
            System.out.println(fm2);
        } catch (Exception e) {
            System.out.println("erreur " + e);
        }
    }

}
