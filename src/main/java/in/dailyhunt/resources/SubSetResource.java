package in.dailyhunt.resources;


import com.codahale.metrics.annotation.Timed;
import in.dailyhunt.resources.requests.ArraysNumber;
import in.dailyhunt.resources.responses.SubSetArray;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Path("/dperf")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubSetResource {


    @POST
    @Timed(name = "dpsubarray")
    public SubSetArray getSubArray(ArraysNumber arraysNumber) {

        int[][] subsets = getSubsets(arraysNumber.getNumbers());
        SubSetArray subSetArray = new SubSetArray();
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
