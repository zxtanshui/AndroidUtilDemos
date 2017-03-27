package com.xinxiong.androidutilsdemo.EditTextActivity;

import android.os.Environment;

/**
 * Created by maowenqiang on 16/11/1.
 */
public class Constants {

    public static final String LegalH5 = "http://h5.jyyall.cc/#/agreement";

    public final static String DEVICE_TYPE = "android";

    public final static int SOCKET_GET_MSG = 3;
    public final static int SOCKET_RECEIVE_MSG_CHAT = 5;//处理会话列表
    public final static int SOCKET_RECEIVE_MSG_CHAT_RECORD = 6;//处理聊天记录
    public final static int SOCKET_CLEAR_MSG_CHAT_RECORD = 7;//清除聊天记录
    public static final int SOCKET_RECONNECT_FAIL = 8;//socket重连失败
    public static final int SOCKET_RECONNECT_SUCCESS = 9;//socket重连成功
    public static final int SOCKET_CLEAR_UNREAD = 10;//清除未读数
    public final static int FILE_CHOOSED_COUNT = 4;

    public final static int UPLOAD_SIZE = 1024 * 64; //分块上传文件的块大小
    public final static int DOWNLOAD_SIZE = 1024 * 200; //分块下载文件的块大小
    public final static int DOWNLOAD_TASK_NUM = 1;    //同时下载的最大任务数
    public final static int UPLOAD_TASK_NUM = 1;    //同时上传的最大任务数
    public final static String DOWNLOAD_PATH = Environment.getExternalStorageDirectory() + "/download_jyall/";
    public final static String TMP_PREVIEW_DOWNLOAD_PATH = Environment.getExternalStorageDirectory() + "/download_tmp_preview/";


    public static final String CHAT_TYPE = "CHAT_TYPE_TAG";
    public static final String CHAT_NAME = "CHAT_NAME_TAG";
    public static final String CHAT_ID = "CHAT_ID_TAG";
    public static final String CHAT_AVATAR = "CHAT_AVATAR_TAG";
    public static final int SOCKET_HERAT_DISCONNECT = 2;
    public final static String ROOT = "root";
    public final static int CLOUD_TYPE_PRIVATE = 1;   //个人云盘
    public final static int CLOUD_TYPE_SHARE = 2;     //共享云盘
    public final static int DOWNLOAD_IM = 3;     //用于IM下载使用，区分于个人云盘和共享云盘
    //上传
    public final static int TAG_UPLOAD_SERVICE = 0x11;
    public final static int TAG_UPLOAD_ACTIVITY = 0x12;
    //下载
    public final static int TAG_DOWNLOAD_SERVICE = 0x21;
    public final static int TAG_DOWNLOAD_ACTIVITY = 0x22;
    //下载/上传状态
    public final static int LOAD_STATE_WAIT = -1; //等待
    public final static int LOAD_STATE_ERROR = 0;   //失败
    public final static int LOAD_STATE_SUCCESS = 1;  //成功
    public final static int LOAD_STATE_LOADING = 2; //正在
    public final static int LOAD_STATE_PAUSE = 3;   //暂停
    public final static String DOWNLOAD_TEMP = ".loading";
    //RecyclerView的type
    public final static int HEADER = 1; //头
    public final static int BODY = 0;   //主体
    public final static int FOOTER = -1;    //脚
    //页面跳转参数传递中的key
    public final static String FAMILY_ID = "familyId";
    public final static String FAMILY_NAME = "familyName";
    public final static String FILE_PARENT = "fileParent";
    public final static String FILE_NAME = "fileName";
    public final static String FILE_TYPE = "fileType";
    public final static String ROOM_TYPE = "roomType";
    public final static String CLOUD_TYPE = "cloudType";
    public final static String SELECT_POSITION = "selectPosition";
    public final static String UPLOAD_PATH = "uploadPath";
    public final static String FILE_SELECT = "fileSelect";
    public final static String SINGLE_SELECT = "singleSelect";
    public final static String FILE_OPTION = "fileOption";
    public final static String FROM_USER = "fromUser";
    public final static String TO_USER = "toUser";
    public final static String AVATAR = "avatar";
    public final static String NICKNAME = "nickname";
    public final static String TITLE = "title";
    public final static String PERIOD_TIME = "periodTime";
    public final static String CHAT_FILE_TYPE = "chatFileType";
    //房间类型
    public final static String FILE_TYPE_PICTURE = "picture";
    public final static String FILE_TYPE_VIDEO = "video";
    public final static String FILE_TYPE_TXT = "txt";
    public final static String FILE_TYPE_AUDIO = "audio";
    public final static String FILE_TYPE_WORK = "work";
    public final static String FILE_TYPE_OTHER = "other";
    public final static String FILE_TYPE_LAST = "last"; //最近上传
    public final static String FILE_TYPE_ALL = "all"; //全部
    public final static String FILE_TYPE_SHARE = "share"; //全部
    //文件选择类型
    public final static int FILE_SELECT_TYPE_PICTURE = 1;
    public final static int FILE_SELECT_TYPE_VIDEO = 2;
    public final static int FILE_SELECT_TYPE_AUDIO = 3;
    public final static int FILE_SELECT_TYPE_DOC = 4;
    public final static int FILE_SELECT_TYPE_OTHER = 5;
    //文件操作
    public final static int OPTION_UPLOAD = 1;
    public final static int OPTION_MOVE = 2;
    //文件排序
    public final static String ORDER_BY_NAME = "0";
    public final static String ORDER_BY_TIME = "1";
    //每次请求文件的个数
    public final static int FILE_PAGE_SIZE = 15;
    //我的文件还是全部文件
    public final static int ALL_FILE = 0;
    public final static int MY_FILE = 1;
    //上传文件-->文件来源
    public final static String UPLOAD_SOURCE_IM = "im";
    public final static String UPLOAD_SOURCE_IM_HIDE = "im_hide";
    public final static String UPLOAD_SOURCE_SHARE = "share";
    public final static String UPLOAD_SOURCE_NORMAL = "normal";
    public final static String UPLOAD_SOURCE_BACKUP = "backup";  //只作为前端标识，

    public static class Chat {
        public static final int REQUEST_CODE_EMPTY_HISTORY = 2;
        public static final int REQUEST_CODE_CONTEXT_MENU = 3;
        public static final int REQUEST_CODE_MAP = 4;
        public static final int REQUEST_CODE_TEXT = 5;
        public static final int REQUEST_CODE_VOICE = 6;
        public static final int REQUEST_CODE_PICTURE = 7;
        public static final int REQUEST_CODE_LOCATION = 8;
        public static final int REQUEST_CODE_NET_DISK = 9;
        public static final int REQUEST_CODE_FILE = 10;
        public static final int REQUEST_CODE_COPY_AND_PASTE = 11;
        public static final int REQUEST_CODE_PICK_VIDEO = 12;
        public static final int REQUEST_CODE_DOWNLOAD_VIDEO = 13;
        public static final int REQUEST_CODE_VIDEO = 14;
        public static final int REQUEST_CODE_DOWNLOAD_VOICE = 15;
        public static final int REQUEST_CODE_SELECT_USER_CARD = 16;
        public static final int REQUEST_CODE_SEND_USER_CARD = 17;
        public static final int REQUEST_CODE_CAMERA = 18;
        public static final int REQUEST_CODE_LOCAL = 19;//相册多选图片
        public static final int REQUEST_CODE_CLICK_DESTORY_IMG = 20;
        public static final int REQUEST_CODE_GROUP_DETAIL = 21;
        public static final int REQUEST_CODE_SELECT_VIDEO = 23;
        public static final int REQUEST_CODE_SELECT_FILE = 24;
        public static final int REQUEST_CODE_ADD_TO_BLACKLIST = 25;
        public static final int REQUEST_CODE_SELECT_AUDIO = 26;//选择音频文件
        public static final int REQUEST_CODE_FILE_LIB = 27;//文件库
        public static final int REQUEST_CODE_SELECT_DOC = 28;//选择文档文件
        public static final int REQUEST_CODE_SELECT_OTHER = 29;//选择其他文件

        public static final int RESULT_CODE_COPY = 1;
        public static final int RESULT_CODE_DELETE = 2;
        public static final int RESULT_CODE_FORWARD = 3;
        public static final int RESULT_CODE_OPEN = 4;
        public static final int RESULT_CODE_DWONLOAD = 5;
        public static final int RESULT_CODE_TO_CLOUD = 6;
        public static final int RESULT_CODE_EXIT_GROUP = 7;

        public static final int CHATTYPE_SINGLE = 1;
        public static final int CHATTYPE_GROUP = 2;

        public static final String COPY_IMAGE = "EASEMOBIMG";
    }

}
