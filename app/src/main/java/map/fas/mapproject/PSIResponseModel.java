package map.fas.mapproject;

import java.util.ArrayList;

/**
 * Created by faprilia on 9/17/17.
 */

public class PSIResponseModel {
    private final Region_metadata region_metadata[];
    private final ArrayList<Item> items;
    private final Api_info api_info;

    public PSIResponseModel(Region_metadata[] region_metadata, ArrayList<Item> items, Api_info api_info) {
        this.region_metadata = region_metadata;
        this.items = items;
        this.api_info = api_info;
    }

    public Region_metadata[] getRegion_metadata() {
        return region_metadata;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Api_info getApi_info() {
        return api_info;
    }

    public static final class Region_metadata {
        public final String name;
        public final Label_location label_location;

        public Region_metadata(String name, Label_location label_location) {
            this.name = name;
            this.label_location = label_location;
        }

        public String getName() {
            return name;
        }

        public Label_location getLabel_location() {
            return label_location;
        }

        public static final class Label_location {
            public final double latitude;
            public final double longitude;

            public Label_location(double latitude, double longitude) {
                this.latitude = latitude;
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public double getLongitude() {
                return longitude;
            }
        }
    }

    public static final class Item {
        public final String timestamp;
        public final String update_timestamp;
        public final Readings readings;

        public Item(String timestamp, String update_timestamp, Readings readings) {
            this.timestamp = timestamp;
            this.update_timestamp = update_timestamp;
            this.readings = readings;
        }

        public static final class Readings {
            public final ReadingDetails o3_sub_index;
            public final ReadingDetails pm10_twenty_four_hourly;
            public final ReadingDetails pm10_sub_index;
            public final ReadingDetails co_sub_index;
            public final ReadingDetails pm25_twenty_four_hourly;
            public final ReadingDetails so2_sub_index;
            public final ReadingDetails co_eight_hour_max;
            public final ReadingDetails no2_one_hour_max;
            public final ReadingDetails so2_twenty_four_hourly;
            public final ReadingDetails pm25_sub_index;
            public final ReadingDetails psi_twenty_four_hourly;
            public final ReadingDetails o3_eight_hour_max;

            public Readings(ReadingDetails o3_sub_index, ReadingDetails pm10_twenty_four_hourly, ReadingDetails pm10_sub_index, ReadingDetails co_sub_index, ReadingDetails pm25_twenty_four_hourly, ReadingDetails so2_sub_index, ReadingDetails co_eight_hour_max, ReadingDetails no2_one_hour_max, ReadingDetails so2_twenty_four_hourly, ReadingDetails pm25_sub_index, ReadingDetails psi_twenty_four_hourly, ReadingDetails o3_eight_hour_max) {
                this.o3_sub_index = o3_sub_index;
                this.pm10_twenty_four_hourly = pm10_twenty_four_hourly;
                this.pm10_sub_index = pm10_sub_index;
                this.co_sub_index = co_sub_index;
                this.pm25_twenty_four_hourly = pm25_twenty_four_hourly;
                this.so2_sub_index = so2_sub_index;
                this.co_eight_hour_max = co_eight_hour_max;
                this.no2_one_hour_max = no2_one_hour_max;
                this.so2_twenty_four_hourly = so2_twenty_four_hourly;
                this.pm25_sub_index = pm25_sub_index;
                this.psi_twenty_four_hourly = psi_twenty_four_hourly;
                this.o3_eight_hour_max = o3_eight_hour_max;
            }

            public static final class ReadingDetails {
                public final double west;
                public final double national;
                public final double east;
                public final double central;
                public final double south;
                public final double north;

                public ReadingDetails(long west, long national, long east, long central, long south, long north) {
                    this.west = west;
                    this.national = national;
                    this.east = east;
                    this.central = central;
                    this.south = south;
                    this.north = north;
                }
            }
        }
    }

    public static final class Api_info {
        public final String status;

        public Api_info(String status) {
            this.status = status;
        }
    }
}
