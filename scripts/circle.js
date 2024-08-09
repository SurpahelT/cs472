$(document).ready(function () {
    const container = $('#container');

    $('#start').click(function () {
        // Get input values and set defaults if not provided
        const initialWidth = parseInt($('#width').val()) || 50;
        const growthAmount = parseInt($('#growthAmount').val()) || 10;
        const growRate = parseInt($('#growRate').val()) || 250;
        const numCircles = parseInt($('#numCircles').val()) || 1;

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
            width: initialWidth,
            height: initialWidth,
            left: posX,
            top: posY
        });

        container.append(circle);

        // Grow the circle at the specified interval
        const intervalId = setInterval(() => {
            const newWidth = circle.width() + growthAmount;
            circle.css({
                width: newWidth,
                height: newWidth
            });
        }, growRate);

        // Remove circle on click
        circle.click(function () {
            clearInterval(intervalId);
            $(this).remove();
        });
    }
});
