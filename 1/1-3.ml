let rec rozne(list, value) = list = [] || (List.hd list <> value && rozne(List.tl list, value));;

rozne([5;3;2], 1);;
rozne([5;3;2], 2);;
