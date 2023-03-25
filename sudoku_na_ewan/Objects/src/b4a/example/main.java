package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static double[][] _grid = null;
public anywheresoftware.b4a.objects.PanelWrapper _board = null;
public anywheresoftware.b4a.objects.LabelWrapper[] _cells = null;
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
int _left = 0;
int _top = 0;
int _width = 0;
int _height = 0;
int _a = 0;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Dim left, top, width, height As Int";
_left = 0;
_top = 0;
_width = 0;
_height = 0;
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="left = 0";
_left = (int) (0);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="top = 0";
_top = (int) (0);
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="width = board.Width/9";
_width = (int) (mostCurrent._board.getWidth()/(double)9);
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="height = board.Height/9";
_height = (int) (mostCurrent._board.getHeight()/(double)9);
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="For a = 0 To 80";
{
final int step7 = 1;
final int limit7 = (int) (80);
_a = (int) (0) ;
for (;_a <= limit7 ;_a = _a + step7 ) {
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="cells(a).Initialize(\"\")";
mostCurrent._cells[_a].Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="Select Case a";
switch (_a) {
case 0: 
case 2: 
case 10: 
case 18: 
case 20: 
case 6: 
case 8: 
case 16: 
case 24: 
case 26: 
case 30: 
case 32: 
case 40: 
case 48: 
case 50: 
case 54: 
case 56: 
case 64: 
case 72: 
case 74: 
case 60: 
case 62: 
case 70: 
case 78: 
case 80: {
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="cells(a).Color =  Colors.LightGray";
mostCurrent._cells[_a].setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 break; }
case 1: 
case 9: 
case 11: 
case 19: 
case 7: 
case 15: 
case 17: 
case 25: 
case 31: 
case 39: 
case 41: 
case 49: 
case 55: 
case 63: 
case 65: 
case 73: 
case 61: 
case 69: 
case 71: 
case 79: {
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="cells(a).Color =  Colors.White";
mostCurrent._cells[_a].setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 break; }
case 3: 
case 5: 
case 13: 
case 21: 
case 23: 
case 27: 
case 29: 
case 37: 
case 45: 
case 47: 
case 33: 
case 35: 
case 43: 
case 51: 
case 53: 
case 57: 
case 59: 
case 67: 
case 75: 
case 77: {
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="cells(a).Color =  Colors.White";
mostCurrent._cells[_a].setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 break; }
case 4: 
case 12: 
case 14: 
case 22: 
case 28: 
case 36: 
case 38: 
case 46: 
case 34: 
case 42: 
case 44: 
case 52: 
case 58: 
case 66: 
case 68: 
case 76: {
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="cells(a).Color =  Colors.LightGray";
mostCurrent._cells[_a].setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 break; }
default: {
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="cells(a).Color = Colors.ARGB(127,Rnd(0,256),Rn";
mostCurrent._cells[_a].setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (127),anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (256)),anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (256)),anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (256))));
 break; }
}
;
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="cells(a).TextColor = Colors.Black";
mostCurrent._cells[_a].setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="cells(a).TextSize = 12";
mostCurrent._cells[_a].setTextSize((float) (12));
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="cells(a).Typeface = Typeface.SANS_SERIF";
mostCurrent._cells[_a].setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SANS_SERIF);
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="cells(a).Gravity = Gravity.CENTER";
mostCurrent._cells[_a].setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="board.AddView(cells(a),left,top,width,height)";
mostCurrent._board.AddView((android.view.View)(mostCurrent._cells[_a].getObject()),_left,_top,_width,_height);
RDebugUtils.currentLine=131106;
 //BA.debugLineNum = 131106;BA.debugLine="left = left + (board.Width/9)";
_left = (int) (_left+(mostCurrent._board.getWidth()/(double)9));
RDebugUtils.currentLine=131108;
 //BA.debugLineNum = 131108;BA.debugLine="If ((a+1) Mod 9 = 0) Then";
if (((_a+1)%9==0)) { 
RDebugUtils.currentLine=131109;
 //BA.debugLineNum = 131109;BA.debugLine="left = 0";
_left = (int) (0);
RDebugUtils.currentLine=131110;
 //BA.debugLineNum = 131110;BA.debugLine="top = top + (board.Height/9)";
_top = (int) (_top+(mostCurrent._board.getHeight()/(double)9));
 };
 }
};
RDebugUtils.currentLine=131114;
 //BA.debugLineNum = 131114;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return "";
}
public static String  _populategrid_board() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "populategrid_board", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "populategrid_board", null));}
int _row = 0;
int _col = 0;
anywheresoftware.b4a.objects.EditTextWrapper _cell = null;
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub PopulateGrid_board()";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="For row = 0 To 8";
{
final int step1 = 1;
final int limit1 = (int) (8);
_row = (int) (0) ;
for (;_row <= limit1 ;_row = _row + step1 ) {
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="For col = 0 To 8";
{
final int step2 = 1;
final int limit2 = (int) (8);
_col = (int) (0) ;
for (;_col <= limit2 ;_col = _col + step2 ) {
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Dim cell As EditText = board.GetView(row * 9 +";
_cell = new anywheresoftware.b4a.objects.EditTextWrapper();
_cell = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(mostCurrent._board.GetView((int) (_row*9+_col)).getObject()));
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="If grid(row, col) > 0 Then";
if (_grid[_row][_col]>0) { 
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="cell.Text = grid(row, col)";
_cell.setText(BA.ObjectToCharSequence(_grid[_row][_col]));
RDebugUtils.currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="cell.Enabled = False ' Disable input for pre-f";
_cell.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="cell.Text = \"\"";
_cell.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=262154;
 //BA.debugLineNum = 262154;BA.debugLine="cell.Enabled = True ' Enable input for empty c";
_cell.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 }
};
 }
};
RDebugUtils.currentLine=262159;
 //BA.debugLineNum = 262159;BA.debugLine="End Sub";
return "";
}
}