/*
 * Copyright (C) 2008-2016 ratking. All wrongs reserved.
 *
 * 用法：将本文件复制到/resources/js/locales_zh.js，然后在JSF页面里使用<h:outputScript name="js/locales_zh.js"/>
 */

PrimeFaces.locales['zh_CN'] = {
    closeText: '关闭',
    prevText: '上个月',
    nextText: '下个月',
    monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
    monthNamesShort: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
    dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
    dayNamesShort: ['日', '一', '二', '三', '四', '五', '六'],
    dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
    weekHeader: '周',
    firstDay: 0, // The first day of the week, Sun = 0, Mon = 1, ...
    isRTL: false, // True if right-to-left language, false if left-to-right
    showMonthAfterYear: true,
    yearSuffix: '', //年
    timeOnlyTitle: '仅时间',
    timeText: '时间',
    hourText: '时',
    minuteText: '分',
    secondText: '秒',
    currentText: '今天',
    ampm: false,
    month: '月',
    week: '周',
    day: '日',
    allDayText: '全天',
    aria: {
        'paginator.PAGE': '第{0}页',
        'calendar.BUTTON': '显示日历',
        'datatable.sort.ASC': '激活升序列',
        'datatable.sort.DESC': '激活降序列',
        'columntoggler.CLOSE': '关闭'
    }
};

PrimeFaces.locales['zh_TW'] = {
    closeText: '關閉',
    prevText: '上個月',
    nextText: '下個月',
    monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
    monthNamesShort: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
    dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
    dayNamesShort: ['日', '一', '二', '三', '四', '五', '六'],
    dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
    weekHeader: '周',
    firstDay: 0, // The first day of the week, Sun = 0, Mon = 1, ...
    isRTL: false, // True if right-to-left language, false if left-to-right
    showMonthAfterYear: true,
    yearSuffix: '', //年
    timeOnlyTitle: '僅時間',
    timeText: '時間',
    hourText: '時',
    minuteText: '分',
    secondText: '秒',
    currentText: '今天',
    ampm: false,
    month: '月',
    week: '周',
    day: '日',
    allDayText: '全天',
    aria: {
        'paginator.PAGE': '第{0}頁',
        'calendar.BUTTON': '顯示日曆',
        'datatable.sort.ASC': '激活升序列',
        'datatable.sort.DESC': '激活降序列',
        'columntoggler.CLOSE': '關閉'
    }
};

PrimeFaces.locales['zh'] = PrimeFaces.locales['zh_CN'];
