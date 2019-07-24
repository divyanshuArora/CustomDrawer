package app.divyanshu.customdrawer;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.drawer_item)
public class drawer_menu_item
{
    public static final int DRAWER_MENU_ITEM_PROFILE = 1;
    public static final int DRAWER_MENU_ITEM_REQUESTS = 2;
    public static final int DRAWER_MENU_ITEM_GROUPS = 3;
    public static final int DRAWER_MENU_ITEM_MESSAGE = 4;
    public static final int DRAWER_MENU_ITEM_NOTIFICATIONS = 5;
    public static final int DRAWER_MENU_ITEM_SETTINGS = 6;
    public static final int DRAWER_MENU_ITEM_TERMS = 7;
    public static final int DRAWER_MENU_ITEM_LOGOUT = 8;


    public int mMenuPosition;
    public Context mContext;
    public DrawerCallBack mCallBack;

    @View(R.id.itemNameTxt)
    private TextView itemNameTxt;

    @View(R.id.itemIcon)
    public ImageView itemIcon;

    public drawer_menu_item(Context context, int menuPosition) {
        mContext = context;
        mMenuPosition = menuPosition;
    }


    @Resolve
    private void onResolved()
    {

        switch (mMenuPosition)
        {

            case DRAWER_MENU_ITEM_PROFILE:
                itemNameTxt.setText("Profile");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_account));
                break;

            case DRAWER_MENU_ITEM_MESSAGE:
                itemNameTxt.setText("Message");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_email));
                break;

            case DRAWER_MENU_ITEM_NOTIFICATIONS:
                itemNameTxt.setText("Notification");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_notifications_black_24dp));
                break;


            case DRAWER_MENU_ITEM_REQUESTS:
                 itemNameTxt.setText("Request");
                 itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_request));
                 break;

            case DRAWER_MENU_ITEM_LOGOUT:
                itemNameTxt.setText("Logout");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_logout));
                break;

        }
    }


    @Click(R.id.mainView)
    private void onMenuItemClick()
    {
        switch(mMenuPosition)
        {

            case DRAWER_MENU_ITEM_MESSAGE:
                Toast.makeText(mContext, "message", Toast.LENGTH_SHORT).show();
                if (mCallBack != null)
                {
                    mCallBack.onMessagesMenuSelected();
                }
                break;


            case DRAWER_MENU_ITEM_NOTIFICATIONS:
                Toast.makeText(mContext, "Notification", Toast.LENGTH_SHORT).show();
                if (mCallBack != null)
                {
                    mCallBack.onNotificationsMenuSelected();
                }
                break;

        }
    }







    public interface DrawerCallBack{
        void onProfileMenuSelected();
        void onRequestMenuSelected();
        void onGroupsMenuSelected();
        void onMessagesMenuSelected();
        void onNotificationsMenuSelected();
        void onSettingsMenuSelected();
        void onTermsMenuSelected();
        void onLogoutMenuSelected();
    }







}
