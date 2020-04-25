package com.fish.eFish;

import android.os.Parcel;
import android.os.Parcelable;

public class models {

    public static class Chatroom implements Parcelable {

        private String id;
        private String Doc_id;
        private String Fish_location;
        private String Fish_name;
        private String Seller_address;
        private String Seller_name;
        private int phone_number;
        private int Fish_price;
        private int Fish_quantity;


        public void setId(String id) {
            this.id = id;
        }

        public void setDoc_id(String doc_id) {
            Doc_id = doc_id;
        }

        public void setFish_location(String fish_location) {
            Fish_location = fish_location;
        }

        public void setFish_name(String fish_name) {
            Fish_name = fish_name;
        }

        public void setSeller_address(String seller_address) {
            Seller_address = seller_address;
        }

        public void setSeller_name(String seller_name) {
            Seller_name = seller_name;
        }

        public void setPhone_number(int phone_number) {
            this.phone_number = phone_number;
        }

        public void setFish_price(int fish_price) {
            Fish_price = fish_price;
        }

        public void setFish_quantity(int fish_quantity) {
            Fish_quantity = fish_quantity;
        }

        public Chatroom(String title, String chatroom_id, String id, String doc_id, String fish_location, String fish_name, String seller_address, String seller_name, int phone_number, int fish_price, int fish_quantity) {
            this.id = id;
            this.Doc_id = doc_id;
            this.Fish_location = fish_location;
            this. Fish_name = fish_name;
            this.Seller_address = seller_address;
            this.Seller_name = seller_name;
            this.phone_number = phone_number;
            this.Fish_price = fish_price;
            this.Fish_quantity = fish_quantity;
        }

        public Chatroom() {

        }

        public String getId() {
            return id;
        }

        public String getDoc_id() {
            return Doc_id;
        }

        public String getFish_location() {
            return Fish_location;
        }

        public String getFish_name() {
            return Fish_name;
        }

        public String getSeller_address() {
            return Seller_address;
        }

        public String getSeller_name() {
            return Seller_name;
        }

        public int getPhone_number() {
            return phone_number;
        }

        public int getFish_price() {
            return Fish_price;
        }

        public int getFish_quantity() {
            return Fish_quantity;
        }

        protected Chatroom(Parcel in) {

            id = in.readString();;
            Doc_id = in.readString();;
            Fish_location = in.readString();;
             Fish_name = in.readString();;
            Seller_address = in.readString();;
            Seller_name = in.readString();;
            phone_number = in.readInt();
            Fish_price = in.readInt();
            Fish_quantity = in.readInt();

        }

        public final Creator<Chatroom> CREATOR = new Creator<Chatroom>() {
            @Override
            public Chatroom createFromParcel(Parcel in) {
                return new Chatroom(in);
            }

            @Override
            public Chatroom[] newArray(int size) {
                return new Chatroom[size];
            }
        };


        @Override
        public String toString() {
            return "Chatroom{" +
                    "id='" + id + '\'' +
                    ", Doc_id='" + Doc_id + '\'' +
                    ", Fish_location='" + Fish_location + '\'' +
                    ", Fish_name='" + Fish_name + '\'' +
                    ", Seller_address='" + Seller_address + '\'' +
                    ", Seller_name='" + Seller_name + '\'' +
                    ", phone_number='" + phone_number + '\'' +
                    ", Fish_price='" + Fish_price + '\'' +
                    ", Fish_quantity='" + Fish_quantity + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(Doc_id);
            dest.writeString(Fish_location);
            dest.writeString(Fish_name);
            dest.writeString(Seller_address);
            dest.writeString(Seller_name);
            dest.writeInt(phone_number);
            dest.writeInt(Fish_price);
            dest.writeInt(Fish_quantity);
        }
    }
}
