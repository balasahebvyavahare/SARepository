package j_completereference;

class A1 {
int k;
 boolean istrue;
 static int p;
public void printValue() {
System.out.print(k);
System.out.print(istrue);
System.out.print(p);
}
}
public class DefaultValue{
 public static void main(String argv[]){

 A1 a = new A1();

 a.printValue();
 }
}


/*Global and static variable need not be initialized before use. Default value of global and
static int variable is zero. Default value of boolean variable is false. Remember local
variable must be initialized before use. */