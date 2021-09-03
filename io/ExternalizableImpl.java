import java.io.*;

class Car implements Externalizable {
    static int age;
    String name;
    int year;

    public Car() {
        System.out.println("Default Constructor called");
    }

    Car(String n, int y) {
        this.name = n;
        this.year = y;
        age = 10;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeInt(year);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        year = in.readInt();
        age = in.readInt();
    }

    @Override
    public String toString() {
        return ("Name: " + name + " " + "Year: " + year + " " + "Age: " + age);
    }
}

public class ExternalizableImpl {
    public static void main(String[] args) {
        Car car = new Car("XYZ", 1997);
        Car newcar = null;

        // Serialize the car
        FileOutputStream fo = null;
        ObjectOutputStream so = null;
        try {
            fo = new FileOutputStream("extSer.txt");
            so = new ObjectOutputStream(fo);
            so.writeObject(car);
            so.flush();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                fo.close();
                so.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Deserializa the car
        FileInputStream fi = null;
        ObjectInputStream si = null;
        try {
            fi = new FileInputStream("extSer.txt");
            si = new ObjectInputStream(fi);
            newcar = (Car) si.readObject();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                fi.close();
                si.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The original car is:\n" + car);
        System.out.println("The new car is:\n" + newcar);
    }
}