package BinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 8, 12, 14, 15, 18, 21, 33, 44, 55, 68, 78, 99};
        int elem = 55;
//        System.out.println(linearSearch(arr, 55));
//        System.out.println(binarySearch(arr, 55));

        int[] arr1 = {99, 88, 77, 66, 55, 44, 33, 22, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int elem1 = 1;
//        System.out.println(binarySearchDescendingSortedArray(arr1, elem1));
//        System.out.println(binarySearchOrderAgnostic(arr1, elem1));
        int[] arr2 = {2, 4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 18, 20};
//        System.out.println(findFirstOccuranceInAnArray(arr2, 10));
//        System.out.println(findLastOccuranceInAnArray(arr2, 10));
//        System.out.println(countOfAnElementInAnArray(arr2, 10));
        int[] A = {1,3};
//        int[] A = {8, 9, 10, 1, 2, 3, 4, 5, 6, 7};

//        System.out.println("The array is rotated " + findNumberOfRotations(A) + " times");
//        System.out.println("In the rotated array the "+elem + " is \nlocated at "
//                + findAnElementInRotatedSortedArray(A, 1) + "th index");

        int[] B = {5, 10, 32, 20, 40};
        int elem2 = 32;
//        System.out.println("In a nearly sorted array the " + elem2 + " is located \n at index " + searchinginNearlySortedArray(B, elem2));
        int[] C = {1, 2, 3, 4, 8, 10, 12, 19};
//        System.out.println("Floor of elem is located at \nindex "+findFloorInSortedArray(C, 5));
//        System.out.println("Ceil of elem is located at \nindex "+findCeilInSortedArray(C, 13));
        char[] D = {'a', 'b', 'c', 'd', 'e'};
//        System.out.println("Ceil of char elem is located at \nindex "+findNextCharInASortedArray(D, 'd'));

        int[] E = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        System.out.println(indexOfFirst1inBinarySortedArray(E));

        int[] F = {1, 3, 8, 10, 15};
//        System.out.println(minDiffElemInSortedArray(F, 12));

        int[] G = {5, 10, 15, 12, 11, 10, 9, 8, 6, 5, 4, 3, 2, 1};
//        System.out.println("Peak element is at " + peakElement(G));
//        System.out.println("Peak element is att " + findPeakElement(G));

        int[]H = {1,5,7,9,12,25,22,19,14,3,2};
//        System.out.println("Element in a Bitonic array is at " +SearchAnElementinBitonicArray(H, 2));


//        sqrt(10000);
        int [] A1 = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(A1, target));
    }


    public static void sqrt(int x){
        int left = 0;
        int right = x+1;
        while(left < right){
            int mid = left + (right-left)/2;
            if (mid*mid>x){
                right = mid;
            }else {
                left = mid +1;
            }
        }
        System.out.println(left-1);
    }


    public static int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(A[mid] == target) {
                return mid;
            }
            else if(A[mid] > target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }

    public static int linearSearch(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                System.out.println(" the element " + elem + " occurs at " + i + "th index");
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int elem) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // to avoid int overflow
            if (arr[mid] == elem) {
                return mid;
            } else if (arr[mid] > elem) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchWithStartEnd(int[] arr, int elem, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2; // to avoid int overflow
            if (arr[mid] == elem) {
                return mid;
            } else if (arr[mid] > elem) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchDescendingSortedArray(int[] arr, int elem) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // to avoid int overflow
            if (arr[mid] == elem) {
                return mid;
            } else if (arr[mid] > elem) {
                start = mid + 1; //change
            } else {
                end = mid - 1;//change
            }
        }
        return -1;
    }



    public static int binarySearchDescendingSortedArrayWithStartEnd(int[] arr, int elem, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2; // to avoid int overflow
            if (arr[mid] == elem) {
                return mid;
            } else if (arr[mid] > elem) {
                start = mid + 1; //change
            } else {
                end = mid - 1;//change
            }
        }
        return -1;
    }


    public static int binarySearchOrderAgnostic(int[] arr, int elem) {
        // we dnt know if the are is ascending or descending
        if (arr.length < 2) {
            if (elem == arr[0]) {
                return 0;
            }
        }
        if (arr[0] > arr[1]) {
            int idxElem = binarySearchDescendingSortedArray(arr, elem);
            return idxElem;
        } else {
            int idxElem = binarySearch(arr, elem);
            return idxElem;
        }
    }


    public static int findFirstOccuranceInAnArray(int[] arr, int elem) {
        int start = 0;
        int res = -1;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (elem == arr[mid]) {
                res = mid;
                end = mid - 1;
            } else if (elem < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }


    public static int findFirstOccuranceInAnArrayWithStartEnd(int[] arr, int elem, int start, int end) {
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (elem == arr[mid]) {
                res = mid;
                end = mid - 1; // since we have to find first occurrence lets find before also
            } else if (elem < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static int findLastOccuranceInAnArray(int[] arr, int elem) {
        int start = 0;
        int res = -1;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (elem == arr[mid]) {
                res = mid;
                start = mid + 1;
            } else if (elem < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }


    public static int countOfAnElementInAnArray(int[] arr, int elem) {
        int start = findFirstOccuranceInAnArray(arr, elem);
        int end = findLastOccuranceInAnArray(arr, elem);
        return end - start + 1;
    }


    public static int findNumberOfRotations(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            if (A[left] <= A[right]) {
                return left;
            }
            int mid = (left + right) / 2;
            int next = (mid + 1) % A.length;
            int prev = (mid - 1) % A.length;
            if (A[mid] <= A[next] && A[mid] <= A[prev]) {
                return mid;
            } else if (A[mid] <= A[right]) {
                right = mid - 1;
            } else if (A[mid] >= A[left]) {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static int findAnElementInRotatedSortedArray(int[] arr, int elem) {
        int idx = findNumberOfRotations(arr);
        int start = 0;
        int end = arr.length - 1;
        int leftIdx = binarySearchWithStartEnd(arr, elem, start, idx - 1);
        int rightIdx = binarySearchWithStartEnd(arr, elem, idx, end);
        if (leftIdx >= 0) {
            return leftIdx;
        } else if (rightIdx >= 0) {
            return rightIdx;
        } else {
            return -1;
        }
    }

    public static int searchinginNearlySortedArray(int[] arr, int elem) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == elem) {
                return mid;
            }
            if (mid - 1 >= start && elem == arr[mid - 1]) {
                return mid - 1;
            }
            if (mid + 1 <= end && elem == arr[mid + 1]) {
                return mid + 1;
            }
            if (elem < arr[mid - 1]) {
                end = mid - 2;
            }
            if (elem > arr[mid + 1]) {
                start = mid + 2;
            }
        }
        return -1;
    }

    public static int findFloorInSortedArray(int[] arr, int elem) {
        int res = 0;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == elem) {
                return mid;
            } else if (arr[mid] < elem) {
                res = mid;
                start = mid + 1;
            } else if (arr[mid] > elem) {
                end = mid - 1;
            }
        }
        return res;
    }


    public static int findCeilInSortedArray(int[] arr, int elem) {
        int res = 0;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == elem) {
                return mid;
            } else if (arr[mid] < elem) {
                start = mid + 1;
            } else if (arr[mid] > elem) {
                res = mid;
                end = mid - 1;
            }
        }
        return res;
    }


    public static int findNextCharInASortedArray(char[] arr, char key) {
        char res = '#';
        int idx = 0;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                start = mid + 1; //keep searching
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                res = arr[mid];
                idx = mid;
                end = mid - 1;
            }
        }
        return idx;
    }


    public static int binarySearchInfiiteArray(int[] arr, int elem) {
        int start = 0;
        int end = 1;
        while (elem > arr[end]) { // jab tak key greater aa rahi hai tab tak badhai end ko
            start = end;
            end = end * 2;
        }
        int idx = binarySearchWithStartEnd(arr, elem, start, end);
        return idx;
    }


    public static int indexOfFirst1inBinarySortedArray(int[] arr) {
        int start = 0;
        int end = 1;
        while (1 > arr[end]) { // jab tak key greater aa rahi hai tab tak badhai end ko
            start = end;
            end = end * 2;
        }
        int idx = findFirstOccuranceInAnArrayWithStartEnd(arr, 1, start, end);
        return idx;
    }


    public static int minDiffElemInSortedArray(int[] arr, int elem) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // to avoid int overflow
            if (arr[mid] == elem) {
                return arr[mid];
            } else if (arr[mid] > elem) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return Math.min(Math.abs(arr[start] - elem), Math.abs(arr[end] - elem));
    }

    public static int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = (low + high) / 2;

            int mid1 = mid + 1;
            if(nums[mid] > nums[mid1]){
                high = mid;
            }
            else {
                low = mid1;
            }
        }
        return low;
    }


    public static int peakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int size = arr.length;
        if(size ==1){
            return 0;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < size - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid - 1] > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (mid == size) {
                if (arr[size -1] > arr[size - 2]) {
                    return size -1;
                } else {
                    return size - 2;
                }
            }
        }
        return -1;
    }

    public static int SearchAnElementinBitonicArray(int[] arr, int elem) {
        int peakIdx = peakElement(arr);
        int inceasingIdx = binarySearchWithStartEnd(arr, elem, 0, peakIdx - 1);
        int decreasingIdx = binarySearchDescendingSortedArrayWithStartEnd(arr, elem, peakIdx, arr.length - 1);
        if (inceasingIdx > 0) {
            return inceasingIdx;
        } else if (decreasingIdx > 0) {
            return decreasingIdx;
        } else {
            return -1;
        }

    }


}
