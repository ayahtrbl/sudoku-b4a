package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,31);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _left = RemoteObject.createImmutable(0);
RemoteObject _top = RemoteObject.createImmutable(0);
RemoteObject _width = RemoteObject.createImmutable(0);
RemoteObject _height = RemoteObject.createImmutable(0);
int _a = 0;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="Dim left, top, width, height As Int";
Debug.ShouldStop(4);
_left = RemoteObject.createImmutable(0);Debug.locals.put("left", _left);
_top = RemoteObject.createImmutable(0);Debug.locals.put("top", _top);
_width = RemoteObject.createImmutable(0);Debug.locals.put("width", _width);
_height = RemoteObject.createImmutable(0);Debug.locals.put("height", _height);
 BA.debugLineNum = 36;BA.debugLine="left = 0";
Debug.ShouldStop(8);
_left = BA.numberCast(int.class, 0);Debug.locals.put("left", _left);
 BA.debugLineNum = 37;BA.debugLine="top = 0";
Debug.ShouldStop(16);
_top = BA.numberCast(int.class, 0);Debug.locals.put("top", _top);
 BA.debugLineNum = 38;BA.debugLine="width = board.Width/9";
Debug.ShouldStop(32);
_width = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._board.runMethod(true,"getWidth"),RemoteObject.createImmutable(9)}, "/",0, 0));Debug.locals.put("width", _width);
 BA.debugLineNum = 39;BA.debugLine="height = board.Height/9";
Debug.ShouldStop(64);
_height = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._board.runMethod(true,"getHeight"),RemoteObject.createImmutable(9)}, "/",0, 0));Debug.locals.put("height", _height);
 BA.debugLineNum = 41;BA.debugLine="For a = 0 To 80";
Debug.ShouldStop(256);
{
final int step7 = 1;
final int limit7 = 80;
_a = 0 ;
for (;(step7 > 0 && _a <= limit7) || (step7 < 0 && _a >= limit7) ;_a = ((int)(0 + _a + step7))  ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 42;BA.debugLine="cells(a).Initialize(\"\")";
Debug.ShouldStop(512);
main.mostCurrent._cells.getArrayElement(false,BA.numberCast(int.class, _a)).runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 43;BA.debugLine="Select Case a";
Debug.ShouldStop(1024);
switch (BA.switchObjectToInt(_a,BA.numberCast(int.class, 0),BA.numberCast(int.class, 2),BA.numberCast(int.class, 10),BA.numberCast(int.class, 18),BA.numberCast(int.class, 20),BA.numberCast(int.class, 6),BA.numberCast(int.class, 8),BA.numberCast(int.class, 16),BA.numberCast(int.class, 24),BA.numberCast(int.class, 26),BA.numberCast(int.class, 30),BA.numberCast(int.class, 32),BA.numberCast(int.class, 40),BA.numberCast(int.class, 48),BA.numberCast(int.class, 50),BA.numberCast(int.class, 54),BA.numberCast(int.class, 56),BA.numberCast(int.class, 64),BA.numberCast(int.class, 72),BA.numberCast(int.class, 74),BA.numberCast(int.class, 60),BA.numberCast(int.class, 62),BA.numberCast(int.class, 70),BA.numberCast(int.class, 78),BA.numberCast(int.class, 80),BA.numberCast(int.class, 1),BA.numberCast(int.class, 9),BA.numberCast(int.class, 11),BA.numberCast(int.class, 19),BA.numberCast(int.class, 7),BA.numberCast(int.class, 15),BA.numberCast(int.class, 17),BA.numberCast(int.class, 25),BA.numberCast(int.class, 31),BA.numberCast(int.class, 39),BA.numberCast(int.class, 41),BA.numberCast(int.class, 49),BA.numberCast(int.class, 55),BA.numberCast(int.class, 63),BA.numberCast(int.class, 65),BA.numberCast(int.class, 73),BA.numberCast(int.class, 61),BA.numberCast(int.class, 69),BA.numberCast(int.class, 71),BA.numberCast(int.class, 79),BA.numberCast(int.class, 3),BA.numberCast(int.class, 5),BA.numberCast(int.class, 13),BA.numberCast(int.class, 21),BA.numberCast(int.class, 23),BA.numberCast(int.class, 27),BA.numberCast(int.class, 29),BA.numberCast(int.class, 37),BA.numberCast(int.class, 45),BA.numberCast(int.class, 47),BA.numberCast(int.class, 33),BA.numberCast(int.class, 35),BA.numberCast(int.class, 43),BA.numberCast(int.class, 51),BA.numberCast(int.class, 53),BA.numberCast(int.class, 57),BA.numberCast(int.class, 59),BA.numberCast(int.class, 67),BA.numberCast(int.class, 75),BA.numberCast(int.class, 77),BA.numberCast(int.class, 4),BA.numberCast(int.class, 12),BA.numberCast(int.class, 14),BA.numberCast(int.class, 22),BA.numberCast(int.class, 28),BA.numberCast(int.class, 36),BA.numberCast(int.class, 38),BA.numberCast(int.class, 46),BA.numberCast(int.class, 34),BA.numberCast(int.class, 42),BA.numberCast(int.class, 44),BA.numberCast(int.class, 52),BA.numberCast(int.class, 58),BA.numberCast(int.class, 66),BA.numberCast(int.class, 68),BA.numberCast(int.class, 76))) {
case 0: 
case 1: 
case 2: 
case 3: 
case 4: 
case 5: 
case 6: 
case 7: 
case 8: 
case 9: 
case 10: 
case 11: 
case 12: 
case 13: 
case 14: 
case 15: 
case 16: 
case 17: 
case 18: 
case 19: 
case 20: 
case 21: 
case 22: 
case 23: 
case 24: {
 BA.debugLineNum = 45;BA.debugLine="cells(a).Color =  Colors.LightGray";
Debug.ShouldStop(4096);
main.mostCurrent._cells.getArrayElement(false,BA.numberCast(int.class, _a)).runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray"));
 break; }
case 25: 
case 26: 
case 27: 
case 28: 
case 29: 
case 30: 
case 31: 
case 32: 
case 33: 
case 34: 
case 35: 
case 36: 
case 37: 
case 38: 
case 39: 
case 40: 
case 41: 
case 42: 
case 43: 
case 44: {
 BA.debugLineNum = 48;BA.debugLine="cells(a).Color =  Colors.White";
Debug.ShouldStop(32768);
main.mostCurrent._cells.getArrayElement(false,BA.numberCast(int.class, _a)).runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 break; }
case 45: 
case 46: 
case 47: 
case 48: 
case 49: 
case 50: 
case 51: 
case 52: 
case 53: 
case 54: 
case 55: 
case 56: 
case 57: 
case 58: 
case 59: 
case 60: 
case 61: 
case 62: 
case 63: 
case 64: {
 BA.debugLineNum = 51;BA.debugLine="cells(a).Color =  Colors.White";
Debug.ShouldStop(262144);
main.mostCurrent._cells.getArrayElement(false,BA.numberCast(int.class, _a)).runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 break; }
case 65: 
case 66: 
case 67: 
case 68: 
case 69: 
case 70: 
case 71: 
case 72: 
case 73: 
case 74: 
case 75: 
case 76: 
case 77: 
case 78: 
case 79: 
case 80: {
 BA.debugLineNum = 54;BA.debugLine="cells(a).Color =  Colors.LightGray";
Debug.ShouldStop(2097152);
main.mostCurrent._cells.getArrayElement(false,BA.numberCast(int.class, _a)).runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray"));
 break; }
default: {
 BA.debugLineNum = 57;BA.debugLine="cells(a).Color = Colors.ARGB(127,Rnd(0,256),Rn";
Debug.ShouldStop(16777216);
main.mostCurrent._cells.getArrayElement(false,BA.numberCast(int.class, _a)).runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 127)),(Object)(main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 256)))),(Object)(main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 256)))),(Object)(main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 256))))));
 break; }
}
;
 BA.debugLineNum = 60;BA.debugLine="cells(a).TextColor = Colors.Black";
Debug.ShouldStop(134217728);
main.mostCurrent._cells.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 61;BA.debugLine="cells(a).TextSize = 12";
Debug.ShouldStop(268435456);
main.mostCurrent._cells.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 62;BA.debugLine="cells(a).Typeface = Typeface.SANS_SERIF";
Debug.ShouldStop(536870912);
main.mostCurrent._cells.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"SANS_SERIF"));
 BA.debugLineNum = 63;BA.debugLine="cells(a).Gravity = Gravity.CENTER";
Debug.ShouldStop(1073741824);
main.mostCurrent._cells.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 64;BA.debugLine="board.AddView(cells(a),left,top,width,height)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._board.runVoidMethod ("AddView",(Object)((main.mostCurrent._cells.getArrayElement(false,BA.numberCast(int.class, _a)).getObject())),(Object)(_left),(Object)(_top),(Object)(_width),(Object)(_height));
 BA.debugLineNum = 65;BA.debugLine="left = left + (board.Width/9)";
Debug.ShouldStop(1);
_left = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_left,(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._board.runMethod(true,"getWidth"),RemoteObject.createImmutable(9)}, "/",0, 0))}, "+",1, 0));Debug.locals.put("left", _left);
 BA.debugLineNum = 67;BA.debugLine="If ((a+1) Mod 9 = 0) Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_a),RemoteObject.createImmutable(1)}, "+",1, 1)),RemoteObject.createImmutable(9)}, "%",0, 1),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 68;BA.debugLine="left = 0";
Debug.ShouldStop(8);
_left = BA.numberCast(int.class, 0);Debug.locals.put("left", _left);
 BA.debugLineNum = 69;BA.debugLine="top = top + (board.Height/9)";
Debug.ShouldStop(16);
_top = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_top,(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._board.runMethod(true,"getHeight"),RemoteObject.createImmutable(9)}, "/",0, 0))}, "+",1, 0));Debug.locals.put("top", _top);
 };
 }
}Debug.locals.put("a", _a);
;
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,97);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 97;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,93);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 93;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Dim grid(9,9) As Double";
main._grid = RemoteObject.createNewArray ("double", new int[] {9,9}, new Object[]{});
 //BA.debugLineNum = 25;BA.debugLine="Private board As Panel";
main.mostCurrent._board = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim cells(81) As Label";
main.mostCurrent._cells = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {81}, new Object[]{});
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _populategrid_board() throws Exception{
try {
		Debug.PushSubsStack("PopulateGrid_board (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,76);
if (RapidSub.canDelegate("populategrid_board")) { return b4a.example.main.remoteMe.runUserSub(false, "main","populategrid_board");}
int _row = 0;
int _col = 0;
RemoteObject _cell = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
 BA.debugLineNum = 76;BA.debugLine="Sub PopulateGrid_board()";
Debug.ShouldStop(2048);
 BA.debugLineNum = 78;BA.debugLine="For row = 0 To 8";
Debug.ShouldStop(8192);
{
final int step1 = 1;
final int limit1 = 8;
_row = 0 ;
for (;(step1 > 0 && _row <= limit1) || (step1 < 0 && _row >= limit1) ;_row = ((int)(0 + _row + step1))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 79;BA.debugLine="For col = 0 To 8";
Debug.ShouldStop(16384);
{
final int step2 = 1;
final int limit2 = 8;
_col = 0 ;
for (;(step2 > 0 && _col <= limit2) || (step2 < 0 && _col >= limit2) ;_col = ((int)(0 + _col + step2))  ) {
Debug.locals.put("col", _col);
 BA.debugLineNum = 80;BA.debugLine="Dim cell As EditText = board.GetView(row * 9 +";
Debug.ShouldStop(32768);
_cell = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
_cell = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.EditTextWrapper"), main.mostCurrent._board.runMethod(false,"GetView",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_row),RemoteObject.createImmutable(9),RemoteObject.createImmutable(_col)}, "*+",1, 1))).getObject());Debug.locals.put("cell", _cell);
 BA.debugLineNum = 81;BA.debugLine="If grid(row, col) > 0 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean(">",main._grid.getArrayElement(true,BA.numberCast(int.class, _row),BA.numberCast(int.class, _col)),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 82;BA.debugLine="cell.Text = grid(row, col)";
Debug.ShouldStop(131072);
_cell.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main._grid.getArrayElement(true,BA.numberCast(int.class, _row),BA.numberCast(int.class, _col))));
 BA.debugLineNum = 83;BA.debugLine="cell.Enabled = False ' Disable input for pre-f";
Debug.ShouldStop(262144);
_cell.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 85;BA.debugLine="cell.Text = \"\"";
Debug.ShouldStop(1048576);
_cell.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 86;BA.debugLine="cell.Enabled = True ' Enable input for empty c";
Debug.ShouldStop(2097152);
_cell.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 };
 }
}Debug.locals.put("col", _col);
;
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}