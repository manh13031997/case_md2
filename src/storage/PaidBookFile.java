package storage;

import model.PaidBooks;

import java.io.*;
import java.util.ArrayList;

public class PaidBookFile {
    public ArrayList<PaidBooks> readFile(){
        File file = new File("list.paidBook");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            ArrayList<PaidBooks> paidBooks = (ArrayList<PaidBooks>) result;
            ois.close();
            fis.close();
            return  paidBooks;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void writeFile(ArrayList<PaidBooks> arrayList) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("list.paidBook");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            oos.close();
            fos.close();
        }
    }
}
