type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let lTake (index: int) (llist: 'a llist) =
	let rec lTakeIt (i: int) (ll: 'a llist) (nl: 'a list) =
		if i = 0
			then List.rev nl
			else match ll with
				LNil -> List.rev nl |
				LCons(x,xf) -> lTakeIt (i -1) (xf()) (x::nl)
	in lTakeIt index llist [];;
	
let rec toLazy (list: 'a list) =
	match list with
		[] -> LNil |
		h::t -> LCons(h, function () -> toLazy t);;
		
let rec lOperation (left: int llist) (right: int llist) (operator: int -> int -> int) =
	match (left, right) with
		(LNil, LNil) -> LNil |
		(LNil, _) -> right |
		(_, LNil) -> left |
		(LCons(lh, lt), LCons(rh, rt)) -> LCons(operator lh rh, function () -> lOperation (lt()) (rt()) operator);;
			
toLazy [1;3;5;7;9;11];;
toLazy [2;4;6;8];;

lTake 20 (lOperation (toLazy [1;3;5;7;9;11]) (toLazy [2;4;6;8]) ( + ));;
lTake 20 (lOperation (toLazy [1;3;5;7;9;11]) (toLazy [2;4;6;8]) ( * ));;
lTake 20 (lOperation (toLazy [1;3;5;7;9;11]) (toLazy [2;4;6;8]) ( - ));;
lTake 20 (lOperation (toLazy [1;3;5;7;9;11]) (toLazy [2;4;6;8]) ( / ));;

