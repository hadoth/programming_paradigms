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
		
let lPowers (base: int) = 
	let rec powerIt (value: int) =
		LCons(value, function () -> powerIt(value * base))
	in powerIt 1;;
	
lTake 20 (lPowers 2);;
