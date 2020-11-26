$(function(){
    let topDiv = $('.tabset')
    let anchors = $('.tabs a')
    let panelDivs = $('div.panel')

    anchors.show();
    panelDivs.hide();
    
    let lastAnchor = anchors.filter('.on')
    let lastPanel = $(lastAnchor.attr('href'))
    lastPanel.show();

    // anchors.each(function(){
    //     $(this).click( ()=>{

    //     })
    // })

    anchors.click(function(){
        lastAnchor.removeClass('on')
        
        let currentAnchor = $(this)
        currentAnchor.addClass('on')
        let currentPanel = $(currentAnchor.attr('href'))

        lastPanel.hide();
        currentPanel.show();

        lastAnchor = currentAnchor;
        lastPanel = currentPanel;
    })

})
