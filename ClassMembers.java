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

    }

    public String toString(int t) {

        if (classMembers == null) {
            return methoddecl.toString(t) + "" + methoddecls.toString(t);
        } else if (methoddecl == null){
            return fielddecl.toString(t) + "" + classMembers.toString(t);
        }else{
            return "";
        }


    }

}