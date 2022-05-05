package lesson4;

public class lesson4 {
    public static void main(String[] args) {
        LocationData[] locationData = LocationData.values();
        for (int i = 0; i < locationData.length; i++) {
            System.out.println(locationData[i].toString() + "ip: " + locationData[i].getIp());

            LocationData location = LocationData.valueOf(LocationData.GBR.toString());
            //LocationData location = LocationData.valueOf("GBR");
            System.out.println("City: " + location.getCity() + "ip: " + location.getIp());
        }
    }


    class MyMonth {
        int days = 0;

        String monthName;

    }

    enum LocationData{
        GBR("London", "213.171.197.181"),
        USA("New York", "69.147.251.50"),
        AUS("Sydney", "223.252.33.75"),
        NZL("New Roads", "49.50.242.137"),
        IRL("Dublin", "176.34.184.134"),
        BRA("Brasilia", "81.95.121.251");

        private final String city;

        private final String ip;

        LocationData(String city, String ip) {
            this.city = city;
            this.ip = ip;
        }

        public String getCity() {
            return city;
        }

        public String getIp() {
            return ip;
        }
    }
}
