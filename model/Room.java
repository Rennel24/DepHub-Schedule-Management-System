    package model;
    public class Room {
        private String roomName;
        private int capacity;

        // Constructor
        public Room(String roomName, int capacity) {
            this.roomName = roomName;
            this.capacity = capacity;
        }

        // Getters
        public String getRoomName() {
            return roomName;
        }

        public int getCapacity() {
            return capacity;
        }

        // Setters (optional, in case room info needs updating)
        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        // Override equals to compare rooms by name
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Room other = (Room) obj;
            return roomName.equalsIgnoreCase(other.roomName);
        }

        @Override
        public String toString() {
            return roomName + " (Capacity: " + capacity + ")";
        }
    }
