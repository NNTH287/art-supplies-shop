(function ($) {
    "use strict";
    
    // Dropdown on mouse hover
    $(document).ready(function () {
        function toggleNavbarMethod() {
            if ($(window).width() > 992) {
                $('.navbar .dropdown').on('mouseover', function () {
                    $('.dropdown-toggle', this).trigger('click');
                }).on('mouseout', function () {
                    $('.dropdown-toggle', this).trigger('click').blur();
                });
            } else {
                $('.navbar .dropdown').off('mouseover').off('mouseout');
            }
        }
        toggleNavbarMethod();
        $(window).resize(toggleNavbarMethod);
    });
    
    
    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });


    // Vendor carousel
    $('.vendor-carousel').owlCarousel({
        loop: true,
        margin: 29,
        nav: false,
        autoplay: true,
        smartSpeed: 1000,
        responsive: {
            0:{
                items:2
            },
            576:{
                items:3
            },
            768:{
                items:4
            },
            992:{
                items:5
            },
            1200:{
                items:6
            }
        }
    });


    // Related carousel
    $('.related-carousel').owlCarousel({
        loop: true,
        margin: 29,
        nav: false,
        autoplay: true,
        smartSpeed: 1000,
        responsive: {
            0:{
                items:1
            },
            576:{
                items:2
            },
            768:{
                items:3
            },
            992:{
                items:4
            }
        }
    });


    // Product Quantity
    $('.quantity button').on('click', function () {
        var button = $(this);
        var oldValue = button.parent().parent().find('input').val();
        if (button.hasClass('btn-plus')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        // button.parent().parent().parent().find('input').val(newVal);
        // $('#quantityToBuy').val(newVal);
        button.parent().parent().parent().find('input[name="quantityToBuy"]').val(newVal)

        if (newVal == 0) {
            button.closest("tr").remove();
        }

        var currentCol = button.parent().parent().parent();
        var price = currentCol.prev().text().slice(0,-1).replace(/\./g, '');
        var oldTotal = currentCol.next().text().slice(0,-1).replace(/\./g, '');
        if (button.hasClass('btn-plus')) {
            if(currentCol.hasClass('align-middle')) {
                var newTotal = (parseInt(oldTotal) + parseInt(price));
                var subtotal = parseInt($("#subtotalText").text().slice(0,-1).replace(/\./g, '')) - oldTotal + newTotal;
                var shipping = parseInt($("#shippingText").text().slice(0,-1).replace(/\./g, '')) + 5000;
            }
        } else {
            if(currentCol.hasClass('align-middle')) {
                var newTotal = (parseInt(oldTotal) - parseInt(price));
                var subtotal = parseInt($("#subtotalText").text().slice(0,-1).replace(/\./g, '')) - oldTotal + newTotal;
                var shipping = parseInt($("#shippingText").text().slice(0,-1).replace(/\./g, '')) - 5000;
            }
        }
        var total = subtotal + shipping;
        currentCol.next().text(newTotal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.') + 'đ');
        $("#subtotalText").text(subtotal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.') + 'đ');
        $("#shippingText").text(shipping.toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.') + 'đ');
        $("#totalText").text(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.') + 'đ');
    });

    //Check out info
    $(document).ready(function() {
        $('input[type="checkbox"][id="newaccount"]').change(function() {
            if ($('input[type="password"]').attr('required')) {
                $('input[type="password"]').removeAttr('required');
            } 
            else {
                $('input[type="password"]').attr('required','required');
            }
        });

        
        $('input[type="radio"][id="creditCard"]').change(function() {
            $('input[class="credit-card-info form-control"]').attr('required','required');
        });

        $('input[type="radio"][id="cod"]').change(function() {
            $('input[class="credit-card-info form-control"]').removeAttr('required');
        });
    });
    
})(jQuery);

