

def quickSort(my_list, low_index, high_index):
    if low_index < high_index:
        pivot = my_list[high_index]
        i = low_index - 1
        for j in range(low_index, high_index):
            if my_list[j] <= pivot:
                i = i + 1
                (my_list[i], my_list[j]) = (my_list[j], my_list[i])
        my_list[i + 1], my_list[high_index] = my_list[high_index], my_list[i + 1]
        pi = i + 1
        quickSort(my_list, low_index, pi - 1)
        quickSort(my_list, pi + 1, high_index)
