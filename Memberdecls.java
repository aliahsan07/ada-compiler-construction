
class Memberdecls extends SuperToken implements Token
{

    ClassMembers classMembers;

    public Memberdecls(ClassMembers classMembers){
        this.classMembers = classMembers;
    }

    public String toString(int t){
        return classMembers.toString(t);
    }

    public void typeCheck() throws Exception {
        classMembers.typeCheck();
    }
}