package in.dailyhunt.resources;


import in.dailyhunt.resources.requests.ArraysNumber;
import in.dailyhunt.resources.responses.SubSetArray;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Path("/subsets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubSetResource {

    @POST
    public SubSetArray getSubArray(ArraysNumber arraysNumber) {
        System.out.println(Arrays.toString(arraysNumber.getNumbers()));
        SubSetArray subSetArray = new SubSetArray();
        int[][] subsets = getSubsets(arraysNumber.getNumbers());
        System.out.println(Arrays.toString(subsets));
        subSetArray.setArrays(subsets);
        return subSetArray;
    }

    private int[][] getSubsets(int numbers[]) {
        int n = numbers.length;
        int pow = 1 << n;
        int[][] array1 = new int[pow][];
        for (int i = 0; i < pow; i++) {
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    a[j] = numbers[j];

                }
            }
            array1[i] = a;
        }
        return array1;
    }
}
