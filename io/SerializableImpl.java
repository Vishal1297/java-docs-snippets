import java.io.*;

public class SerializableImpl implements java.io.Serializable
{
	public int age;
	public String name;

	public SerializableImpl(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{name="+name+",age="+age+"}";
    }
    
    public static void main(String[] args)
	{
		SerializableImpl serializableImpl = new SerializableImpl(24, "vishal");
		String filename = "data.ser";
		
		// Serialization
		try
		{
			//Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
            // Method for serialization of object
            System.out.println(serializableImpl);
			out.writeObject(serializableImpl);
			
			out.close();
			file.close();
			System.out.println("Object has been serialized..");
		}catch(IOException ex){
			System.out.println("IOException is caught");
		}

		SerializableImpl serializableImpl2 = null;

		// Deserialization
		try
		{
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			// Method for deserialization of object
			serializableImpl2 = (SerializableImpl)in.readObject();
			in.close();
			file.close();
			
            System.out.println("Object has been deserialized..");
            System.out.println("Name = " + serializableImpl2.name);
			System.out.println("Age = " + serializableImpl2.age);
		}catch(IOException ex){
			System.out.println("IOException is caught");
		}catch(ClassNotFoundException ex){
			System.out.println("ClassNotFoundException is caught");
		}

	}

}