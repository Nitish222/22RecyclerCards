package nitish.example.com.recyclercard;

public class ExampleItem {
    private int mimageresource;
    private String mtext;
    public ExampleItem(int  imageresource,String text){
        mimageresource = imageresource;
        mtext=text;
    }

    public int getMimageresource() {
        return mimageresource;
    }

    public String getMtext() {
        return mtext;
    }
}
