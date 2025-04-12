package com.capstone.Exception;

public class NoDataException  extends RuntimeException {
	public NoDataException(){
        super("No Data Found in DataBase");
        }
	public NoDataException(String message){
	    super(message);
	    }

}
