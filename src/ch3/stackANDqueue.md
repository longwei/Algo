stack is basically linkedlist, stack dont have api to peek nodes
that other than top.

application:
balancing of symbols
  matching tags in html and xml


psedo code:
1. Create a stack
2. while (!end){
	if the char is not a symbol, ignore it.
	if it is a open symbol, push it onto stack
	if it is a closing symbol, pop the stack.
	if pop mismatch, return err
}
if !stack.isEmpty, then err



infix-to-postfix
function call
finding of spans
page-visted or undo




