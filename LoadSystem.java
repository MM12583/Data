package data;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import guests.Customer;

public class LoadSystem{
	
	public static void main(String[] args) throws  FileNotFoundException, IOException, IOException, ClassNotFoundException{
		
		Customer[] list = {new Customer(), new Customer(), new Customer()} ;
		char c = ',' ;
		
		// .csv
		File csvFile = new File("C:/Users/USER/Desktop/data_test/data.csv") ;
		
		try(DataOutputStream outputCSV = new DataOutputStream(new FileOutputStream(csvFile))){
			
			for(Customer o : list ){
				outputCSV.writeUTF(o.getName() + c + o.getGender() + c + o.getPhoneNumber() + "\n") ;
			}
			
		} catch (FileNotFoundException e){
			
		} catch (IOException e) {
			
		}
		
		// .dat
		File datFile = new File("C:/Users/USER/Desktop/data_test/data.dat") ;
		
		try(ObjectOutputStream outputDat = new ObjectOutputStream(new FileOutputStream(datFile))){
			outputDat.writeObject(list) ;
			
		} catch (FileNotFoundException e){
			
		} catch (IOException e) {
			
		}
		
		try(ObjectInputStream inputDat = new ObjectInputStream(new FileInputStream(datFile))){
			
			Customer[] g = (Customer[])inputDat.readObject() ; // *** 儲存類型須轉換, readObject為一次讀取全部物件
			
			for(Customer o : g){
				System.out.println("-----------------------------------------------") ;
				System.out.println(o.getName() + c + o.getGender() + c + o.getPhoneNumber() + c + o.getVisitTimes()) ;
			}
			
		} catch (IOException e){
			System.out.println("讀取完畢") ;
		}
	}

}
