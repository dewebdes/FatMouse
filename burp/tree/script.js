function replaceallstr(ts, tv, rv) {
    while (ts.indexOf(tv) > -1) {
        ts = ts.replace(tv, rv);
    }
    return ts;
}

$(function () {
  let treeview = {
    resetBtnToggle: function() {
      $(".js-treeview")
        .find(".level-add")
        .find("span")
        .removeClass()
        .addClass("fa fa-plus");
      $(".js-treeview")
        .find(".level-add")
        .siblings()
        .removeClass("in");
    },
    addSameLevel: function(target) {
      let ulElm = target.closest("ul");
      let sameLevelCodeASCII = target
        .closest("[data-level]")
        .attr("data-level")
          .charCodeAt(0);

        var tx = prompt('Node Text:');
        var ht = $("#levelMarkup").html();
        ht = replaceallstr(ht, 'Level A', tx);

        ulElm.append(ht);
      ulElm
        .children("li:last-child")
        .find("[data-level]")
          .attr("data-level", String.fromCharCode(sameLevelCodeASCII));
        
        
    },
    addSubLevel: function(target) {
      let liElm = target.closest("li");
        let nextLevelCodeASCII = liElm.find("[data-level]").attr("data-level").charCodeAt(0) + 1;

        var tx = prompt('Node Text:');
        var ht = $("#levelMarkup").html();
        ht = replaceallstr(ht, 'Level A', tx);

        liElm.children("ul").append(ht);
      liElm.children("ul").find("[data-level]")
        .attr("data-level", String.fromCharCode(nextLevelCodeASCII));
    },
    removeLevel: function(target) {
      target.closest("li").remove();
      
    }
  };

  // Treeview Functions
  $(".js-treeview").on("click", ".level-add", function() {
    $(this).find("span").toggleClass("fa-plus").toggleClass("fa-times text-danger");
    $(this).siblings().toggleClass("in");
  });

  // Add same level
    $(".js-treeview").on("click", ".level-same", function () {
        //var tx = prompt('Node Text:');
        //alert(tx);
    treeview.addSameLevel($(this));
    treeview.resetBtnToggle();
  });

  // Add sub level
  $(".js-treeview").on("click", ".level-sub", function() {
    treeview.addSubLevel($(this));
    treeview.resetBtnToggle();
  });
    // Remove Level
  $(".js-treeview").on("click", ".level-remove", function() {
    treeview.removeLevel($(this));
  }); 

  // Selected Level
  $(".js-treeview").on("click", ".level-title", function() {
    let isSelected = $(this).closest("[data-level]").hasClass("selected");
    !isSelected && $(this).closest(".js-treeview").find("[data-level]").removeClass("selected");
    $(this).closest("[data-level]").toggleClass("selected");
  }); 


    
    $(".js-treeview").on("click", ".treeview__level", function () {
        $(this).next().slideToggle();
    }); 

});