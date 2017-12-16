let rec removeElement (list, evens, odds, isEven) = match (list, isEven) with ([], _) -> (List.rev evens, List.rev odds) | (h::t, true) -> removeElement(t, (h*h)::evens, odds, false) | (h::t, false) -> removeElement(t, evens, (3*h)::odds, true);;

let divide (list) = removeElement(list, [], [], true);;

divide [3;6;8;9;13];;
