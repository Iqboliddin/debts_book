package front;

abstract public class BaseResponse {
    public static void response(Boolean status){
        if (status)
            System.out.println("Operation completed successfully!");
        else
            System.out.println("Operation is failed!");
    }
}
