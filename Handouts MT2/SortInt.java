// CS 0401 Fall 2017
// This class includes 2 sorting algorithms.  The first is the selectionSort 
// algorithm from the Gaddis text.  The second is another simple sorting
// algorithm, insertionSort.  See more comments below.

public class SortInt
{
   /**
      The selectionSort method performs a selection sort on an
      int array. The array is sorted in ascending order.
      @param array The array to sort.
   */
   public static void selectionSort(int [] array)
   {
      int startScan, index, minIndex, minValue;

      for (startScan = 0; startScan < (array.length-1); startScan++)
      {
         minIndex = startScan;
         minValue = array[startScan];
         for(index = startScan + 1; index < array.length; index++)
         {
            if (array[index] < minValue)
            {
               minValue = array[index];
               minIndex = index;
            }
         }
         array[minIndex] = array[startScan];
         array[startScan] = minValue;
      }
   }

   // This sort moves the items into sorted order by "inserting" them
   // from the right side of the array (the unsorted part) into the left
   // side of the array (the sorted part).
   public static void insertionSort (int [] array)
   {
   	  // Move each item (starting at index 1) over to its correct spot
   	  // on the "left", sorted side of the array.
      for (int index = 1; index < array.length; index++)
      {
         int key = array[index];
         int position = index;

         // Move the current item to the left "past" any items that 
         // are larger than it.  This is accomplished by shifting the
         // larger items to the right.
         while (position > 0 && key < array[position-1])
         {
            array[position] = array[position-1];
            position--;
         }
            
         array[position] = key;
      }
   }
}