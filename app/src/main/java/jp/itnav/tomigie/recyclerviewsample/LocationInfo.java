package jp.itnav.tomigie.recyclerviewsample;

//
// 場所の情報をもつクラス
//

public class LocationInfo {
    private int imageResourceId;
    private String kariTimei;
    private String timei;
    private String location;
    private String detail;


    public LocationInfo(int imageResourceId, String karitimei, String timei, String location, String detailt) {
        this.imageResourceId = imageResourceId;
        this.kariTimei = karitimei;
        this.timei = timei;
        this.location = location;
        this.detail = detailt;
    }

    public String getKaritimei(){
        return kariTimei;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getTimei() {
        return timei;
    }

    public String getLocation() {
        return location;
    }

    public String getDetail(){
        return detail;
    }
}