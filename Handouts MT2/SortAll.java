// CS 401 Fall 2017
// Modification of Gaddis selectionSort so that it sorts an array of
// any Comparable object.  Compare this handout to SortInt.java and
// to SortAllT.java

public class SortAll
{
   // Note that the parameter type is the interface Comparable.  This
   // means than an array of any class the implements that Comparable
   // interface can be passed into this method (and can be sorted).
   // Note also that the sort algorithm is identical to that in the
   // SortInt.java handout, except for the call of "compareTo" rather
   // than the user of a relational operator.
   public static void selectionSort(Comparable [] array)
   {
      int startScan, index, minIndex;
      Comparable minValue;

      for (startScan = 0; startScan < (array.length-1); startScan++)
      {
         minIndex = startScan;
         minValue = array[startScan];
         for(index = startScan + 1; index < array.length; index++)
         {
            if (array[index].compareTo(minValue) < 0)
            // if (array[index] < minValue)
            {
               minValue = array[index];
               minIndex = index;
            }
         }
         array[minIndex] = array[startScan];
         array[startScan] = minValue;
      }
   }
}