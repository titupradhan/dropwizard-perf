package in.dailyhunt.resources.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubSetArray {

    int[][] arrays;

    @JsonProperty
    public int[][] getArrays() {
        return arrays;
    }

    public void setArrays(int[][] arrays) {
        this.arrays = arrays;
    }
}
