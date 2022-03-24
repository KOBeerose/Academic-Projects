def BinarySearch(arr, left, right, key):
    if right >= left:
        mid = (right + left) // 2
        if arr[mid] == key:
            return mid
        elif arr[mid] > key:
            return BinarySearch(arr, left, mid - 1, key)
        else:
            return BinarySearch(arr, mid + 1, right, key)
    else:
        return -1


array = [1, 2, 7, 10, 15, 25]

print(BinarySearch(array, 0, len(array), 10))
