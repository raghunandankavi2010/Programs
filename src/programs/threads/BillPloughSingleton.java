package programs.threads;


public class BillPloughSingleton {

    // inner static class ensures one instance always
    // when class is loaded inner class is not loaded
   private static class StaticHelper {
        private static final BillPloughSingleton billPloughSIngleton = new BillPloughSingleton();
    }

    // instance created whe first time call to getInstance
    private static BillPloughSingleton getInstance(){
        return StaticHelper.billPloughSIngleton;
    }
}
