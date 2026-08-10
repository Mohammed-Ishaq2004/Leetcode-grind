class Solution {
    public  List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>(); // Initializes the master list to hold all rows

    if (numRows == 0) return result; // Edge Case: Returns an empty list if 0 rows are requested

    List<Integer> firstRow = new ArrayList<>(); // Creates the very first row of the triangle
    firstRow.add(1); // Adds the initial 1 to the first row
    result.add(firstRow); // Appends the completed first row [1] into the master list

    if (numRows == 1) return result; // Edge Case: Returns immediately if only 1 row is requested

    for (int i = 1; i < numRows; i++) { // Loops to generate the remaining subsequent rows
        List<Integer> prevRow = result.get(i - 1); // Fetches the row directly above the current one
        ArrayList<Integer> row = new ArrayList<>(); // Initializes a brand new list for the current row

        row.add(1); // Every row in Pascal's Triangle always starts with 1

        for (int j = 0; j < i - 1; j++) { // Loops through and calculates the middle elements
            row.add(prevRow.get(j) + prevRow.get(j + 1)); // Sums two adjacent elements from the previous row
        }

        row.add(1); // Every row in Pascal's Triangle always ends with 1
        result.add(row); // Adds the newly constructed row to the final master list
    }

    return result; // Returns the completed Pascal's Triangle structure
} 
}
