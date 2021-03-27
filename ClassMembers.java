class ClassMembers implements Token
{
    Fielddecl fielddecl = null;
    ClassMembers classMembers = null;
    Methoddecl methoddecl = null;
    Methoddecls methoddecls = null;


    public ClassMembers(Fielddecl fielddecl, ClassMembers classMembers){
        this.fielddecl = fielddecl;
        this.classMembers = classMembers;
    }

    public ClassMembers(Methoddecl methoddecl, Methoddecls methoddecls){
        this.methoddecl = methoddecl;
        this.methoddecls = methoddecls;
    }

    public ClassMembers(){

    }

    public String toString(int t) {

        if (classMembers == null) {
            return fielddecl.toString(t) + "" + classMembers.toString(t);
        } else if (methoddecl == null){
            return methoddecl.toString(t) + "" + methoddecls.toString(t);
        }else{
            return "";
        }


    }

}