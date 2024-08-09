$(document).ready(function () {
    const container = $('#container');

    $('#start').click(function () {
        // Get input values and set defaults if not provided
        const initialWidth = parseInt($('#width').val(), 10) || 50;
        const growthAmount = parseInt($('#growthAmount').val(), 10) || 10;
        const growRate = parseInt($('#growRate').val(), 10) || 250;
        const numCircles = parseInt($('#numCircles').val(), 10) || 1;

        // Clear previous circles
        container.empty();

        // Create specified number of circles
        for (let i = 0; i < numCircles; i++) {
            createCircle(initialWidth, growthAmount, growRate);
        }
    });

    function createCircle(initialWidth, growthAmount, growRate) {
        const circle = $('<div class="circle"></div>');
        const maxWidth = $(window).width() - initialWidth;
        const maxHeight = $(window).height() - initialWidth;

        // Random position for each circle within bounds
        const posX = Math.random() * maxWidth;
        const posY = Math.random() * maxHeight;

        // Set initial style
        circle.css({
            width: `${initialWidth}px`,  // Use px unit to ensure correct rendering
            height: `${initialWidth}px`, // Use px unit to ensure correct rendering
            left: posX,
            top: posY,
            position: 'absolute' // Make sure the position is absolute for correct placement
        });

        container.append(circle);

        // Grow the circle at the specified interval
        const intervalId = setInterval(() => {
            const newWidth = circle.width() + growthAmount;
            circle.css({
                width: `${newWidth}px`,  // Use px unit to ensure correct rendering
                height: `${newWidth}px`  // Use px unit to ensure correct rendering
            });
        }, growRate);

        // Remove circle on click
        circle.click(function () {
            clearInterval(intervalId);
            $(this).remove();
        });
    }
});
