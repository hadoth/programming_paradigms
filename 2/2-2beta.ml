let rec makeList (list, result) = match (list, result) with ([], _) -> (list, result) | (lh::lt, []) -> makeList(lt, lh::result) | (lh::lt, rh::rt) -> if lh = rh then makeList(lt, lh::result) else (list, result);;

makeList ([1;1;1;1;2;2;1;3;3;4;4], []);;
makeList ([1;1;1;1;2;2;1;3;3;4;4], [1]);;
makeList ([1;1;1;1;2;2;1;3;3;4;4], [1;1]);;


let rec addList (list, result) = if list = [] then List.rev result else let (l,r) = makeList(list, []) in addList(l, r::result);;

addList ([1;1;1;1;2;2;1;3;3;4;4], []);;
