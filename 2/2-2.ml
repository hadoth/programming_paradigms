let rec groupIt (list, element, result) = if list = [] then List.rev result else if element = List.hd list then groupIt (List.tl list, element, (element::(List.hd result))::(List.tl result)) else groupIt (List.tl list, List.hd list, ([List.hd list])::result);;

let group list = if (list = []) then [] else groupIt (List.tl list, List.hd list, ([List.hd list])::[]);;

group ([1;1;1;1;2;3;3;1;1;4;4]);;
