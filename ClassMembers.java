class ClassMembers implements Token
{
    Fielddecl fielddecl;
    ClassMembers classMembers;
    Methoddecl methoddecl;
    Methoddecls methoddecls;


    public ClassMembers(Fielddecl fielddecl, ClassMembers classMembers){
        this.fielddecl = fielddecl;
        this.classMembers = classMembers;
        this.methoddecls = null;
        this.methoddecl = null;

    }

    public ClassMembers(Methoddecl methoddecl, Methoddecls methoddecls){
        this.methoddecl = methoddecl;
        this.methoddecls = methoddecls;
        this.fielddecl = null;
        this.classMembers = null;
    }

    public ClassMembers(){
        this.methoddecl = null;
        this.methoddecls = null;
        this.fielddecl = null;
        this.classMembers = null;

    }

    public String toString(int t) {

        if (methoddecl != null) {
            return methoddecl.toString(t) + "" + (methoddecls == null ? "" : methoddecls.toString(t));
        } else if (fielddecl != null ){
            return fielddecl.toString(t) + "" + (classMembers == null ? "" : classMembers.toString(t));
        }else{
            return "";
        }


    }

}