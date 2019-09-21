function checkVideo() {
    if (document.createElement("video").canPlayType) {
        var t = document.createElement("video");
        return oggTest = t.canPlayType('video/ogg;codecs="theora,vorbis"'),
        oggTest ? "probably" == oggTest: (h264Test = t.canPlayType('video/mp4;codecs="avc1.42E01E,mp4a.40.2"'), !!h264Test && "probably" == h264Test)
    }
    return ! 1
}
function FadeSlide(t, a, e) {
    if (!e && (e = 4e3), !a && (a = "li"), t.data("data-n", 0).find(a + ":gt(0)").hide(), this.rFade = function() {
        t.find(a + ":eq(" + t.data("data-n") + ")").stop(!0, !0).fadeOut(1e3),
        t.find("span.banner_link a").removeClass("hover"),
        t.data("data-n") + 1 > t.find(a).size() - 1 ? t.data("data-n", 0) : t.data("data-n", t.data("data-n") + 1),
        ie6 ? t.find(a + ":eq(" + t.data("data-n") + ")").show() : t.find(a + ":eq(" + t.data("data-n") + ")").fadeIn(1e3),
        t.find("span.banner_link a:eq(" + t.data("data-n") + ")").addClass("hover")
    },
    t.find(a).size() > 1) {
        setInterval(function() {
            this.rFade()
        },
        e)
    }
}
function BigShow(t) {
    var a = Math.ceil(1e5 * Math.random()),
    e = t["data-src"] ? t.attr("data-src") : t.attr("src");
    Locked(),
    $("<img/>").attr("src", e).load(function() {
        var i = this.width,
        o = this.height;
        $("div.locked").css("background", "#000").after('<img src="' + e + '" class="r' + a + '">'),
        $("img.r" + a).css({
            position: "fixed",
            margin: "auto",
            top: t.offset().top - $(window).scrollTop(),
            bottom: $(window).height() - t.height() - t.offset().top + $(window).scrollTop(),
            left: t.offset().left,
            right: $(window).width() - t.width() - t.offset().left,
            width: t.width(),
            height: t.height(),
            maxWidth: "none",
            cursor: "zoom-out",
            zIndex: "9999"
        }).animate({
            top: "0",
            bottom: "0",
            left: "0",
            right: "0",
            width: i,
            height: o
        },
        500,
        function() {
            $("div.locked,img.r" + a).one("click",
            function() {
                $("div.locked,img.r" + a).remove()
            })
        })
    })
}
function MapInfo(t) {
    $("div.map_info").html("<i>关闭</i>").find("i").one("click",
    function() {
        $("div.map_info [data-bgm]")[0] && "语音讲解" != $("div.map_info [data-bgm]").text() && $("div.map_info [data-bgm]").click(),
        $("div.map_info").fadeOut(200)
    }),
    Locked(),
    $.ajax({
        url: $("div.map_info").attr("data-ajax"),
        data: "id=" + t,
        type: ajaxPost,
        success: function(t) {
            UnLocked(),
            "error" == t.split("|")[0] ? Alert(t.split("|")[1] ? t.split("|")[1] : "获取景点详情失败，请稍后重试", "error") : $("div.map_info").append(t).fadeIn(200,
            function() {
                $("div.map_info [data-bgm]")[0] && $("div.map_info [data-bgm]").click()
            }),
            isMobile() && !!localStorage.whois && $("div.map_info [data-url]").each(function() {
                $(this).attr("data-url", $(this).attr("data-url") + ($(this).attr("data-url").split("?")[1] ? "&": "?") + "whois=" + localStorage.whois)
            })
        },
        error: function() {
            UnLocked(),
            Alert("服务器响应超时，请稍后重试")
        }
    })
}
function CanvasIcon(t, a, e, i, o, n) {
    n.append('<img src="' + parentPath + "uploadfile/map/map_" + t + '_icon.png" data-info="' + t + '">'),
    n.find("img[data-info='" + t + "']").css({
        left: a,
        top: e,
        width: i,
        height: o
    }).click(function() {
        MapInfo(t)
    })
}
function BaiduMap(t, a, e, i) {
    var o = new BMap.Map("container", {
        enableMapClick: !1
    });
    if (o.addControl(new BMap.NavigationControl), o.addControl(new BMap.MapTypeControl), t) {
        var n = new BMap.DrivingRoute(o, {
            renderOptions: {
                map: o,
                autoViewport: !0
            }
        });
        n.search(new BMap.Point(t, a), new BMap.Point(e ? e: 112.961926, i ? i: 34.520628))
    } else {
        var r = new BMap.Point(112.959675, 34.520342),
        d = new BMap.Marker(r);
        o.centerAndZoom(r, 16),
        o.enableScrollWheelZoom(),
        o.addOverlay(d),
        d.setAnimation(BMAP_ANIMATION_BOUNCE),
        $("button[data-x]").click(function() {
            $("button[data-x]").removeClass("hover"),
            $(this).addClass("hover"),
            BaiduMap($(this).attr("data-x"), $(this).attr("data-y"))
        })
    }
}
function Pano(t) {
    t = parentPath + "uploadfile/pano/" + t + "/",
    embedpano({
        swf: parentPath + "inc/pano.swf",
        xml: t + "pano.xml",
        target: "pano",
        html5: "prefer",
        passQueryParameters: !1,
        onready: function() {
            $("#krpanoSWFObject pre:last").html(unescape(escape($("#krpanoSWFObject pre:last").html()).replace(/%u6E56%u5357%u7701%u53CB%u8BDA%u79D1%u6280%u6709%u9650%u516C%u53F8/g, "%u5e03%u9c81%u65af%u7f51%u7edc"))),
            setTimeout(function() {
                $("#krpanoSWFObject")[0].set("plugin[button_vr].visible", !0),
                $("#krpanoSWFObject")[0].set("plugin[button_rotate].visible", !0)
            },
            1e3),
            !!$("#pano[data-bgsnd]")[0] && setTimeout(function() {
                $("#krpanoSWFObject")[0].set("plugin[button_sound].visible", !0),
                $("#krpanoSWFObject")[0].call("playsound(bgsnd," + $("#pano").attr("data-bgsnd") + ",1)")
            },
            1e3)
        }
    })
}

function RefreshCode(t) {
    Locked(),
    $.get(t.attr("data-ajax"), {
        vcodeid: "refresh"
    },
    function(a) {
        UnLocked(),
        "done" == a.split("|")[0] && (t.find("input[name='vcodeid']").val(a.split("|")[1]), t.find("img.v").attr("src", t.find("img.v").attr("src").split("=")[0] + "=" + a.split("|")[1]))
    })
}
function Countdown(t) {
    null == GetCookie("songshan_locked") && SetCookie("songshan_locked", t.find("input:text:eq(0)").val()),
    t.find("label.l1 span").text("30"),
    t.find("label:lt(2)").toggle().find("label.l1 span").text("30");
    var a = 30,
    e = setInterval(function() {
        a--,
        t.find("label.l1 span").text(a),
        a <= 0 && (DelCookie("songshan_locked"), t.find("label:lt(2)").toggle(), clearInterval(e))
    },
    1e3)
}
function OrderCheck() {
    $.ajax({
        url: $("div.main form:eq(0)").attr("data-ajax"),
        data: "order_id=" + $("div.main form:eq(0) input:hidden:eq(0)").val(),
        type: ajaxPost,
        success: function(t) {
            "done" == t.split("|")[0] ? Jump($("div.main form:eq(0)").attr("action")) : setTimeout(function() {
                OrderCheck()
            },
            3e3)
        }
    })
}
function Alert(t, a, e) {
    var i = Math.ceil(1e5 * Math.random());
    void 0 == e && (e = !0),
    void 0 == a && (a = "warning"),
    $("div.alert")[0] && $("div.alert").remove(),
    $("body").append('<div class="alert r' + i + '"><span><p>' + t + "</p><button>确定</button></span></div>"),
    $("div.alert span").prepend('<div class="icon icon_' + a + '"><i class="icon_body"></i><i class="icon_dot"></i></div'),
    this.rAlert = function() {
        $("div.alert").css({
            height: $(document).height(),
            width: $(window).width()
        }).find("span").css({
            top: parseInt($(window).height() / 2 - 140) + "px"
        })
    },
    this.rAlert(),
    e && $(window).unbind("resize"),
    $(window).bind("resize",
    function() {
        this.rAlert()
    }),
    $("div.r" + i).fadeTo(200, 1,
    function() {
        $("div.alert button").click(function() {
            $("div.r" + i).remove()
        })
    })
}
function Locked(t) {
    void 0 == t && (t = !0),
    $("div.locked")[0] && $("div.locked").remove(),
    $("body").append('<div class="locked"></div>'),
    this.rLocked = function() {
        $("div.locked").css({
            height: $(document).height(),
            width: $(window).width(),
            backgroundPosition: "center " + parseInt($(window).height() / 2 + $(window).scrollTop()) + "px"
        })
    },
    this.rLocked(),
    t && $(window).unbind("resize"),
    $(window).bind("resize",
    function() {
        this.rLocked()
    }),
    $("div.locked").fadeTo(200, .6)
}
function UnLocked() {
    $("div.locked").remove()
}
function ReAjax(t, a) {
    void 0 != t.split("|")[1] && (a = t.split("|")[1]);
    var e = !0;
    switch (t.split("|")[0]) {
    case "error":
        Alert(void 0 == a ? "Error": a, "error");
        break;
    case "timeout":
        Jump(location.href);
        break;
    default:
        e = !1
    }
    return e
}

function Debug(t) {
    t = t.replace(/</g, "&lt;").replace(/\n/g, "<br>").replace("[info]:", "<font color=red>[info]:</font>").replace("[url]:", "<font color=red>[url]:</font>").replace("[data]:", "<font color=red>[data]:</font>"),
    $("div.debug")[0] || $("body").append('<div class="debug"></div>'),
    $("div.debug").fadeTo(0, .8).prepend(t + "<hr>").dblclick(function() {
        $(this).remove()
    })
}
function isMobile() {
    var t = !1,
    a = ["iphone", "ipod", "ipad", "android", "mobile", "blackberry", "webos", "incognito", "webmate", "bada", "nokia", "lg", "ucweb", "skyfire"],
    e = navigator.userAgent.toLowerCase();
    return $.each(a,
    function(a, i) {
        e.indexOf(i) != -1 && (t = !0)
    }),
    t
}
function Show(t, a) {
    $(t)[0] ? $(t).fadeOut(a).fadeIn(a) : $(t).fadeIn(a)
}
function Hide(t, a) {
    $(t).fadeOut(a)
}
function RegForm(t) {
    var a = !0,
    e = 0;
    return t.find("input,select,textarea").each(function() {
        "" != $(this).attr("data-reg") && null == new RegExp($(this).attr("data-reg")).exec($(this).val()) && (a = !1, e++, $(this).css({
            backgroundColor: "#f8f8f8",
            borderColor: "#9b0000"
        }).one("focusin",
        function() {
            $(this).css({
                backgroundColor: "",
                borderColor: ""
            })
        }))
    }),
    a || Alert("有 " + e + " 处错误，请检查", "error"),
    a
}
function Jump(t) {
    isMobile() && !!localStorage.whois && (t += (t.split("?")[1] ? "&": "?") + "whois=" + localStorage.whois),
    location.href = t
}
function GetVar(t) {
    var a = new RegExp("(^|)" + t + "=([^&]*)(&|$)", "gi").exec(String(location.href));
    return a ? a[2] : ""
}
function SetCookie(t, a) {
    var e = 30,
    i = new Date;
    i.setTime(i.getTime() + 86400 * e * 1e3),
    document.cookie = t + "=" + escape(a) + ";expires=" + i.toGMTString()
}
function GetCookie(t) {
    var a = document.cookie.match(new RegExp("(^| )" + t + "=([^;]*)(;|$)"));
    return null != a ? unescape(a[2]) : null
}
function DelCookie(t) {
    var a = new Date;
    a.setTime(a.getTime() - 1);
    var e = GetCookie(t);
    null != e && (document.cookie = t + "=" + e + ";expires=" + a.toGMTString())
}
var ajaxPost = "GET",
ajaxCache = !0,
parentPath = $("script:first[src^='../../']")[0] ? "../../": "",
ie6 = $.browser.msie && ("6.0" == $.browser.version || "7.0" == $.browser.version && 7 == document.documentMode);
isMobile() && !!GetVar("whois") && (localStorage.whois = GetVar("whois")),
isMobile() && !!localStorage.whois && $("head").append('<link rel="stylesheet" href="' + parentPath + "inc/style_" + localStorage.whois + '.css">'),
$(function() {
    if ($.ajaxSetup({
        timeout: 1e4,
        cache: ajaxCache
    }), ie6 && $("body").prepend('<div class="ie6"><a href="http://ie.microsoft.com/" target="_blank">你的浏览器 IE 版本过低，可能导致某些功能无法正常使用，建议升级浏览器。</a></div>'), $("a").focusin(function() {
        this.blur()
    }), $(".ani img")[0] && $(".ani img").live({
        mouseenter: function() {
            $(this).stop().fadeTo(200, .8)
        },
        mouseleave: function() {
            $(this).stop().fadeTo(200, 1)
        }
    }), $(".show img")[0] && $(".show img").css("cursor", "zoom-in").click(function() {
        BigShow($(this))
    }), $("[data-confirm]")[0] && $("[data-confirm]").live("click",
    function() {
        return confirm($(this).attr("data-confirm"))
    }), $("[data-back]")[0] && $("[data-back]").live("click",
    function() {
        return window.history.go($(this).attr("data-back")),
        !1
    }), $("[data-url]")[0] && $("[data-url]").live("click",
    function() {
        Jump($(this).attr("data-url"))
    }), $("select[data-selected]")[0] && setTimeout(function() {
        $("select[data-selected]").each(function() {
            $(this).find("option[selected]").removeAttr("selected").end().find("option[value='" + $(this).attr("data-selected") + "']").attr("selected", "selected")
        })
    },
    0), $("form").submit(function() {
        return RegForm($(this))
    }), isMobile() && !!localStorage.whois && $("[href]").each(function() {
        $(this).attr("href", $(this).attr("href") + ($(this).attr("href").split("?")[1] ? "&": "?") + "whois=" + localStorage.whois)
    }), isMobile() && "wx" == localStorage.whois && $("div.footer").append('<ul class="language">' + $("div.header ul.language").html() + "</ul>"), isMobile() && $("div.header ul.menu")[0] && ($("div.header ul.menu").before('<span class="menu"></span>'), $("div.header span.menu").click(function() {
        return $(this).next().stop().fadeToggle(100,
        function() {
            $("body").off().one("click",
            function() {
                $("div.header ul.menu").fadeOut(100)
            })
        }),
        !1
    })), $("[data-menu]")[0] && !isMobile() && $.get($("[data-menu]").attr("data-menu"),
    function(t) {
        $("div.header").append(t),
        $("div.header div.menu_sub div").each(function(t) {
            $(this).find("ul").css("backgroundPosition", "115px -" + 132 * t + "px")
        }),
        $("div.header ul.menu a").mouseenter(function() {
            $("div.header div.menu_sub div").hide().eq($(this).parent().index() < 1 ? 200 : $(this).parent().index() - 1).stop(!0, !0).slideDown(200)
        }),
        $("div.header").mouseleave(function() {
            $("div.header div.menu_sub div").stop(!0, !0).slideUp(200)
        })
    }), $("div.footer div.blogroll select").change(function() {
        $(this).val().indexOf("http") != -1 && Jump($(this).val())
    }), !isMobile() && $("div.par img").size() > 1 && FadeSlide($("div.par"), "img"), !isMobile() && $("div.par[class*='ani_cloud']")[0] &&
    function() {
        var t = ($(window).width() - 1200) / 2 < 0 ? -700 : -($(window).width() - 1200) / 2 - 700,
        a = $(window).width() < 1200 ? 1200 : $(window).width();
        $("div.par").append('<span class="cloud_in"></span><span class="cloud_out"></span>').find("span").css("left", t),
        $("div.par span.cloud_in").animate({
            left: a
        },
        52e3,
        function() {
            $("div.par span.cloud_in").fadeOut(2e3)
        }),
        $("div.par span.cloud_out").animate({
            left: a
        },
        42e3,
        function() {
            $("div.par span.cloud_out").fadeOut(2e3)
        })
    } (), !isMobile() && $("div.par[class*='ani_bird']")[0] &&
    function() {
        $("div.par").append('<span class="bird"></span>'),
        $("div.par span.bird").animate({
            left: 1200,
            top: -11,
            width: 53,
            height: 11,
            opacity: 0
        },
        18e3)
    } (), $("[data-bgm]")[0] && $("[data-bgm]").live("click",
    function() {
        "语音讲解" == $(this).text() ? ($("audio[src*='" + $(this).attr("data-bgm") + "']")[0].play(), $(this).addClass("hover").text("语音讲解（播放中）")) : ($("audio[src*='" + $(this).attr("data-bgm") + "']")[0].pause(), $(this).removeClass("hover").text("语音讲解"))
    }), $("body#index")[0] && (isMobile() && Jump($("div.header a:first").attr("href")), !checkVideo() && Jump($("div.header a:first").attr("href")), $("div.full video")[0].onended = function() {
        Jump($("div.header a:first").attr("href"))
    },
    $(window).on("resize",
    function() {
        var t = $(window).height() / 1080 * 1920,
        a = $(window).width() / 1920 * 1080;
        t >= $(window).width() && $("div.full video").css({
            left: "-" + (t - $(window).width()) / 2 + "px",
            width: t,
            top: 0,
            height: "auto"
        }),
        a >= $(window).height() && $("div.full video").css({
            top: "-" + (a - $(window).height()) / 2 + "px",
            height: a,
            left: 0,
            width: "auto"
        })
    }).resize()), $("body#main")[0] && (setTimeout(function() {
        $("div.notice").slideUp(500)
    },
    1e4), $("div.header a.logo img").attr("src", parentPath + "images/logo.png"), FadeSlide($("ul.banner")), $("div.index_link li[class^='img_']").append("<span></span>"), $.get($("div.header div[data-ajax]").attr("data-ajax"),
    function(t) {
        $("div.header div[data-ajax]").append(t)
    })), $("body#about_message")[0] && (null != GetCookie("songshan_locked") && Countdown($("div.main_right form")), $("div.main_right form label:eq(0)").click(function() {
        GetCode($("div.main_right form"))
    }), $("div.main_right form img.v").click(function() {
        RefreshCode($("div.main_right form"))
    }), $("div.main_right form").submit(function() {
        return RegForm($(this)) && (Locked(), $.ajax({
            url: $("div.main_right form").attr("action"),
            data: $("div.main_right form").serialize(),
            type: ajaxPost,
            success: function(t) {
                UnLocked(),
                RefreshCode($("div.main_right form")),
                $("div.main_right form")[0].reset(),
                "done" == t.split("|")[0] ? Alert("信息已提交，我们将尽快处理", "done") : Alert("信息提交失败，请联系客服", "error")
            },
            error: function() {
                UnLocked(),
                Alert("服务器响应超时，请稍后重试")
            }
        })),
        !1
    })), $("body#intro_info")[0] && $("ul.intro_info_slide img[data-src]").click(function() {
        $("ul.intro_info_slide li").removeClass("hover"),
        $(this).parent("li").addClass("hover"),
        $("ul.intro_info_slide li.big img").attr("src", $(this).attr("data-src"))
    }).first().click(), $("body#service_heatmap")[0] && $.getJSON($("div.map_heatmap").attr("data-ajax"),
    function(t) {
        var a = new BMap.Map("container", {
            enableMapClick: !1
        }),
        e = new BMapLib.HeatmapOverlay({
            radius: 80
        }),
        i = new Array;
        a.addControl(new BMap.NavigationControl),
        a.addControl(new BMap.MapTypeControl),
        a.centerAndZoom(new BMap.Point(113.015741, 34.494294), 14),
        a.enableScrollWheelZoom(),
        a.addOverlay(e),
        e.setDataSet({
            data: t,
            max: 100
        });
        for (var o in t) i[o] = new BMap.Marker(new BMap.Point(t[o].lng, t[o].lat)),
        a.addOverlay(i[o]),
        i[o].addEventListener("click",
        function() {
            Alert(t[i.indexOf(this)].name + "热度值: " + t[i.indexOf(this)].count)
        });
        a.setMapStyle({
            style: "grayscale"
        })
    }), $("body#service_info")[0] && $("span.map")[0]) {
        var t = new BMap.Map("container", {
            enableMapClick: !1
        }),
        a = $("div.map_service").attr("data-center").split("|"),
        e = $("div.map_service").attr("data-point").split("|");
        for (t.enableScrollWheelZoom(), t.centerAndZoom(new BMap.Point(a[0].split(",")[0], a[0].split(",")[1]), a[1]), i = 0; i < e.length - 1; i++) new BMap.WalkingRoute(t, {
            renderOptions: {
                map: t,
                autoViewport: !1
            },
            onMarkersSet: function(t) {
                t[0].marker.setZIndex( - 1)
            }
        }).search(new BMap.Point(e[i].split(",")[0], e[i].split(",")[1]), new BMap.Point(e[i + 1].split(",")[0], e[i + 1].split(",")[1]));
        isMobile() && ($("span.map").css({
            left: -9999
        }), $('<p class="button"><button>查看路线图</button></p>').appendTo("div.news_info").click(function() {
            $("span.map").css({
                left: 0
            })
        }))
    }
    if ($("body#map")[0]) if (isMobile()) {
        var o = $("div#guide"),
        n = "wx" == localStorage.whois ? $(window).height() - 37 : $(window).height(),
        r = n / 800;
        o.css({
            height: n,
            width: 1.5 * n,
            backgroundImage: "url(" + parentPath + "uploadfile/map/map_bg.jpg)",
            backgroundSize: "100% 100%"
        }),
        CanvasIcon("1-1", 190 * r, 182 * r, 232 * r, 132 * r, o),
        CanvasIcon("1-2", 122 * r, 170 * r, 79 * r, 107 * r, o),
        CanvasIcon("1-3", 62 * r, 578 * r, 59 * r, 18 * r, o),
        CanvasIcon("1-5", 284 * r, 102 * r, 99 * r, 65 * r, o),
        CanvasIcon("1-6", 476 * r, 218 * r, 88 * r, 78 * r, o),
        CanvasIcon("1-9", 388 * r, 634 * r, 109 * r, 79 * r, o),
        CanvasIcon("2-1", 912 * r, 498 * r, 275 * r, 134 * r, o),
        CanvasIcon("2-2", 1042 * r, 672 * r, 119 * r, 101 * r, o),
        CanvasIcon("2-4", 1064 * r, 346 * r, 59 * r, 17 * r, o),
        CanvasIcon("3-1", 708 * r, 264 * r, 59 * r, 120 * r, o),
        CanvasIcon("3-2", 836 * r, 88 * r, 59 * r, 17 * r, o),
        CanvasIcon("3-3", 856 * r, 326 * r, 111 * r, 78 * r, o),
        CanvasIcon("3-4", 754 * r, 204 * r, 156 * r, 89 * r, o),
        CanvasIcon("3-5", 556 * r, 372 * r, 129 * r, 91 * r, o),
        CanvasIcon("3-7", 740 * r, 422 * r, 200 * r, 130 * r, o)
    } else swfobject.embedSWF(parentPath + "uploadfile/map/map_v01.swf", "guide", $("div#guide").width(), $("div#guide").height(), "10.0.0", "false");
    if ($("body#map_baidu")[0] && (BaiduMap(), !!GetVar("id") && parseInt(GetVar("id")) >= 1 && parseInt(GetVar("id")) <= $("button[data-x]").size() && $("button[data-x]").eq(parseInt(GetVar("id")) - 1).click(), GetVar("to"))) {
        var r = "嵩山景区",
        d = 112.961926,
        s = 34.520628,
        l = "34.514726,112.955477";
        "1-0" == GetVar("to") && (r = "游客中心", d = 112.959675, s = 34.520342, l = "34.514235,112.952548"),
        "1-1" == GetVar("to") && (r = "少林寺", d = 112.948318, s = 34.511343, l = "34.505261,112.941856"),
        "1-2" == GetVar("to") && (r = "少林寺塔林", d = 112.943788, s = 34.509299, l = "34.503120,112.937430"),
        "1-3" == GetVar("to") && (r = "三皇寨", d = 112.935065, s = 34.46887, l = "34.462560,112.928640"),
        "1-4" == GetVar("to") && (r = "初祖庵", d = 112.939488, s = 34.515076, l = "34.508270,112.933280"),
        "1-5" == GetVar("to") && (r = "达摩洞", d = 112.934153, s = 34.519441, l = "34.513320,112.927970"),
        "1-6" == GetVar("to") && (r = "永泰寺", d = 112.984394, s = 34.525617, l = "34.519950,112.977790"),
        "1-7" == GetVar("to") && (r = "少室阙", d = 112.992691, s = 34.498664, l = "34.492980,112.986080"),
        "1-8" == GetVar("to") && (r = "二祖庵", d = 112.943736, s = 34.495668, l = "34.501080,112.937350"),
        "1-9" == GetVar("to") && (r = "莲花寺", d = 112.961045, s = 34.464811, l = "34.458900,112.954840"),
        "2-1" == GetVar("to") && (r = "中岳庙", d = 113.07978, s = 34.460576, l = "34.455090,113.073010"),
        "2-2" == GetVar("to") && (r = "观星台", d = 113.153318, s = 34.404643, l = "34.398390,113.146920"),
        "2-3" == GetVar("to") && (r = "太室阙", d = 113.080673, s = 34.456183, l = "34.450280,113.074400"),
        "2-4" == GetVar("to") && (r = "卢崖瀑布", d = 113.090995, s = 34.484519, l = "34.478750,113.084400"),
        "3-1" == GetVar("to") && (r = "嵩岳寺塔", d = 113.029814, s = 34.505508, l = "34.499435,113.022706"),
        "3-2" == GetVar("to") && (r = "峻极峰", d = 113.053357, s = 34.51618, l = "34.510310,113.047460"),
        "3-3" == GetVar("to") && (r = "老母洞", d = 113.048756, s = 34.501585, l = "34.495310,113.042110"),
        "3-4" == GetVar("to") && (r = "法王寺", d = 113.03309, s = 34.50813, l = "34.501930,113.026540"),
        "3-5" == GetVar("to") && (r = "会善寺", d = 113.011481, s = 34.496096, l = "34.490230,113.004860"),
        "3-6" == GetVar("to") && (r = "启母阙", d = 113.054353, s = 34.4785, l = "34.472207,113.047955"),
        "3-7" == GetVar("to") && (r = "嵩阳书院", d = 113.03963, s = 34.485414, l = "34.478880,113.033420"),
        isMobile() ? Jump("http://apis.map.qq.com/uri/v1/routeplan?type=drive&to=" + r + "&tocoord=" + l + "&referer=blues") : (new BMap.Geolocation).getCurrentPosition(function(t) {
            this.getStatus() == BMAP_STATUS_SUCCESS ? BaiduMap(t.point.lng, t.point.lat, d, s) : BaiduMap(113.019625, 34.45326, d, s)
        },
        {
            enableHighAccuracy: !0
        })
    }
    if ($("body#map_pano")[0]) {
        var r = $("button[data-pano]")[0] ? $("button[data-pano]:first").attr("data-pano") : "VT01"; !! GetVar("id") && $("button[data-pano]").each(function() {
            GetVar("id").replace("-", "") == $(this).attr("data-pano") && (r = $(this).attr("data-pano"))
        }),
        $("button[data-pano]").click(function() {
            $("#krpanoSWFObject")[0] && $("#krpanoSWFObject")[0].call("stopallsounds()"),
            $(this).attr("data-bgsnd") ? $("div#pano").empty().attr("data-bgsnd", parentPath + "uploadfile/intro/" + $(this).attr("data-bgsnd") + ".mp3") : $("div#pano").empty().removeAttr("data-bgsnd"),
            Pano($(this).attr("data-pano")),
            $(this).parent().find("button[data-pano]").removeClass("hover"),
            $(this).addClass("hover")
        }),
        $("button[data-pano='" + r + "']").click(),
        isMobile() && $("button[data-pano]").parent().click(function() {
            $("button[data-pano]").parent().toggleClass("button_hidden")
        })
    }
    if ($("body#service_cameras_info")[0]) {
        var c = WebVideoCtrl.I_CheckPluginInstall();
        if ( - 2 == c) return void Alert("您的Chrome浏览器版本过高，暂不支持NPAPI插件");
        if ( - 1 == c) return void Alert("您还未安装过视频插件，请下载安装并启用");
        $("[data-port]").parent().hide();
        var u = {
            iWidth: $("#camera").width(),
            iHeight: $("#camera").height()
        };
        if (WebVideoCtrl.I_InitPlugin(u.iWidth, u.iHeight, {
            bWndFull: !0,
            iWndowType: 1,
            cbSelWnd: function(t) {}
        }), WebVideoCtrl.I_InsertOBJECTPlugin("camera"), -1 == WebVideoCtrl.I_CheckPluginVersion()) return Alert("检测到新版本视频插件，请下载更新", "done"),
        void $("[data-port]").parent().show();
        var p = {
            iProtocol: 1,
            szIP: "218.28.25.106",
            szPort: $("[data-port]").attr("data-port"),
            szUsername: "admin",
            szPassword: "!$#cntv.cn@CHINA",
            iStreamType: 1,
            iChannelID: 1,
            bZeroChannel: !1
        };
        WebVideoCtrl.I_Login(p.szIP, p.iProtocol, p.szPort, p.szUsername, p.szPassword, {
            success: function(t) {
                WebVideoCtrl.I_StartRealPlay(p.szIP, {
                    iStreamType: p.iStreamType,
                    iChannelID: p.iChannelID,
                    bZeroChannel: p.bZeroChannel
                })
            }
        }),
        $(window).unload(function() {
            WebVideoCtrl.I_Stop()
        }),
        "blues" == GetVar("debug") && null != WebVideoCtrl.I_GetWindowStatus() && $("[data-ptz]").mousedown(function() {
            WebVideoCtrl.I_PTZControl(parseInt($(this).attr("data-ptz")), !1, {
                iPTZSpeed: 2
            })
        }).mouseup(function() {
            WebVideoCtrl.I_PTZControl(1, !0)
        }).parent().show()
    }
    if ($("body#shop")[0] && ($("title").before('<link rel="stylesheet" href="' + parentPath + 'inc/style_calendar.css" type="text/css" />'), $.getScript(parentPath + "inc/jquery_calendar.js",
    function() {
        $("div.shop_search input").each(function() {
            $(this).attr("readonly", "readonly").calendar({
                btnBar: void 0 != $(this).attr("data-format"),
                minDate: $(this).attr("data-mindate"),
                maxDate: $(this).attr("data-maxdate"),
                format: $(this).attr("data-format")
            })
        })
    }), $("div.shop_list li.ticket").append("<span></span>")), $("body#shop_info")[0]) {
        var o = $("div.shop_summary div input");
        o.val(o.attr("data-max") > 0 ? 1 : 0).keyup(function() { / ^[0 - 9] * [1 - 9][0 - 9] * $ / .test($(this).val()) || $(this).val("1"),
            (0 | $(this).val()) > $(this).attr("data-max") && $(this).val($(this).attr("data-max"))
        }),
        $("div.shop_summary span:eq(0)").click(function() {
            0 != o.attr("data-max") && ((0 | o.val()) - 1 > 1 ? o.val((0 | o.val()) - 1) : o.val("1"))
        }),
        $("div.shop_summary span:eq(1)").click(function() {
            0 != o.attr("data-max") && ((0 | o.val()) + 1 < o.attr("data-max") ? o.val((0 | o.val()) + 1) : o.val(o.attr("data-max")))
        }),
        $("div.shop_summary em.type").click(function() {
            $("div.shop_summary em.type").removeClass("hover"),
            $(this).addClass("hover")
        }),
        $("div.shop_goods button.buy").click(function() {
            CartsAdd()
        }),
        $("div.shop_goods button.info").click(function() {
            $("div.shop_goods div.goods_info").fadeToggle(100)
        })
    }
    if ($("body#shop_info")[0] && $("table.unlocked")[0] && DelCookie("songshan_locked"), ($("body#shop_checkmob")[0] || $("body#shop_order")[0]) && (null != GetCookie("songshan_locked") && ($("div.main form:eq(0) input:text:eq(0)").val(GetCookie("songshan_locked")), Countdown($("table.shop_checkmob"))), $("table.shop_checkmob label:eq(0)").click(function() {
        GetCode($("div.main form:eq(0)"))
    }), $("div.main form:eq(0) img.v").click(function() {
        RefreshCode($("div.main form:eq(0)"))
    })), $("body#shop_order")[0]) {
        var o = $("table.shop_order div#address");
        o[0] && o.city(o.attr("data-province"), o.attr("data-city"), o.attr("data-county"))
    }
    $("body#shop_pay")[0] && ($("[data-qr]").qrcode({
        render: ie6 ? "table": "canvas",
        width: ie6 ? 248 : 220,
        height: ie6 ? 248 : 220,
        text: $("[data-qr]").attr("data-qr")
    }), setTimeout(function() {
        OrderCheck()
    },
    5e3))
});