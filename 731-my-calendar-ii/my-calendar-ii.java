class MyCalendarTwo {

    private List<int[]> books;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        books = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        // Check if this new event will cause a triple booking
        for (int[] o : overlaps) {
            if (Math.max(start, o[0]) < Math.min(end, o[1])) {
                return false;
            }
        }

        // Add new double bookings with existing events
        for (int[] b : books) {
            int s = Math.max(start, b[0]);
            int e = Math.min(end, b[1]);
            if (s < e) {
                overlaps.add(new int[]{s, e});
            }
        }

        // Add event to full booking list
        books.add(new int[]{start, end});
        return true;
    }
}
