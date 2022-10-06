(function(c) {
    c.extend(c.expr[":"], {
        nic: function(a, c, d, b) {
            return ! (0 <= (a.textContent || a.innerText || "").toLowerCase().indexOf((d[3] || "").toLowerCase()))
        }
    });
    c.fn.editableSelect = function(a) {
        var g = this.clone(),
        d = c('<input type="text">'),
        b = c('<ul class="es-list">');
        a = c.extend({},
        {
            filter: !0,
            effect: "default",
            duration: "fast",
            onCreate: null,
            onShow: null,
            onHide: null,
            onSelect: null
        },
        a);
        switch (a.effects) {
        case "default":
        case "fade":
        case "slide":
            break;
        default:
            a.effects = "default"
        }
        isNaN(a.duration) && "fast" == a.duration && "slow" == a.duration && (a.duration = "fast");
        this.replaceWith(d); ({
            init: function () {
                d.unbind("input click");
                c(document).unbind("click.test");
                var f = this;
                f.copyAttributes(g, d);
                d.addClass("es-input");
                c(document.body).append(b);
                g.find("option").each(function() {
                    var a = c("<li>");
                    a.html(c(this).text());
                    f.copyAttributes(this, a);
                    b.append(a);
                    c(this).attr("selected") && d.val(c(this).text())
                });
                //d.on("focus input click", f.show);
                d.on("input click", f.show);
                //d.on("focus", function () { console.log(focus); });
                c(document).on("click.test", function (a) {
                    c(a.target).is(d) || c(a.target).is(b) || f.hide()
                });
                f.initializeList();
                f.initializeEvents();
                a.onCreate && a.onCreate.call(this, d)
            },
            initializeList: function () {
                var a = this;
                b.find("li").each(function() {
                    c(this).on("mousemove",
                    function() {
                        b.find(".selected").removeClass("selected");
                        c(this).addClass("selected")
                    });
                    c(this).click(function() {
                        a.setField.call(this, a)
                    })
                });
                b.mouseenter(function() {
                    b.find("li.selected").removeClass("selected")
                })
            },
            initializeEvents: function () {
                //var a = this;
                //d.bind("input keydown",
                //function(c) {
                //    switch (c.keyCode) {
                //    case 40:
                //        a.show();
                //        c = b.find("li:visible");
                //        var e = c.filter("li.selected");
                //        b.find(".selected").removeClass("selected");
                //        e = c.eq(0 < e.size() ? c.index(e) + 1 : 0);
                //        e = (0 < e.size() ? e: b.find("li:visible:first")).addClass("selected");
                //        a.scroll(e, !0);
                //        break;
                //    case 38:
                //        a.show();
                //        c = b.find("li:visible");
                //        e = c.filter("li.selected");
                //        b.find("li.selected").removeClass("selected");
                //        e = c.eq(0 < e.size() ? c.index(e) - 1 : -1); (0 < e.size() ? e: b.find("li:visible:last")).addClass("selected");
                //        a.scroll(e, !1);
                //        break;
                //    case 13:
                //        b.is(":visible") && (a.setField.call(b.find("li.selected"), a), c.preventDefault());
                //    case 9:
                //    case 27:
                //        a.hide();
                //        break;
                //    default:
                //        a.show()
                //    }
                //})
            },
            show: function () {
                b.find("li").show();
                b.css({
                    top: d.offset().top + d.outerHeight() - 1,
                    left: d.offset().left,
                    width: d.innerWidth()
                });
                if ((a.filter ? b.find("li:nic(" + d.val() + ")").hide().size() : 0) == b.find("li").size()) b.hide();
                else switch (a.effects) {
                case "fade":
                    b.fadeIn(a.duration);
                    break;
                case "slide":
                    b.slideDown(a.duration);
                    break;
                default:
                    b.show(a.duration)
                }
                a.onShow && a.onShow.call(this, d)
            },
            hide: function () {
                switch (a.effects) {
                case "fade":
                    b.fadeOut(a.duration);
                    break;
                case "slide":
                    b.slideUp(a.duration);
                    break;
                default:
                    b.hide(a.duration)
                }
                a.onHide && a.onHide.call(this, d)
            },
            scroll: function (a, d) {
                var e = 0,
                h = b.find("li:visible").index(a);
                b.find("li:visible").each(function(a, b) {
                    a < h && (e += c(b).outerHeight())
                });
                if (e + a.outerHeight() >= b.scrollTop() + b.outerHeight() || e <= b.scrollTop()) d ? b.scrollTop(e + a.outerHeight() - b.outerHeight()) : b.scrollTop(e)
            },
            copyAttributes: function (a, b) {
                var e = c(a)[0].attributes,
                d;
                for (d in e) c(b).attr(e[d].nodeName, e[d].nodeValue)
            },
            setField: function (b) {
                if (!c(this).is("li:visible")) return ! 1;
                d.val(c(this).text());
                b.hide();
                a.onSelect && a.onSelect.call(d, c(this))
            }
        }).init();
        return d
    }
})(jQuery);