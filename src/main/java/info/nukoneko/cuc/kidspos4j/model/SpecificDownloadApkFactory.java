package info.nukoneko.cuc.kidspos4j.model;

final public class SpecificDownloadApkFactory {
    private static DataDownloadApkImpl INSTANCE = new DataDownloadApkImpl();
    public static DataDownloadApkImpl getInstance(){
        return INSTANCE;
    }
}
