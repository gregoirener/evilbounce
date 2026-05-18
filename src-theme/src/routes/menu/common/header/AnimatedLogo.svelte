<script lang="ts">
    const idBase = `lb-logo-${Math.random().toString(36).slice(2, 9)}`;
    const bannerGradientId = `${idBase}-banner`;

    const anniversary = (new Date()).getFullYear() - 2016;
</script>

<div class="animated-logo">
    <svg
            class="logo-svg"
            xmlns="http://www.w3.org/2000/svg"
            width="261.263"
            height="98"
            viewBox="0 0 261.263 98"
            role="img"
            aria-label="EvilBounce logo"
    >
        <defs>
            <linearGradient id={bannerGradientId} gradientUnits="userSpaceOnUse" spreadMethod="repeat"
                            x1="48" y1="16" x2="372" y2="164">
                <stop offset="0%" stop-color="#D41717"/>
                <stop offset="50%" stop-color="#fc4130"/>
                <stop offset="100%" stop-color="#D41717"/>
                <animateTransform
                        attributeName="gradientTransform"
                        type="translate"
                        dur="9.1s"
                        repeatCount="indefinite"
                        calcMode="linear"
                        values="0 0; 324 148"
                />
            </linearGradient>
        </defs>

        <g class="mark" transform="translate(0,79.896) scale(1,-1)">
            <path d="M79.9,39.948A39.967,39.967,0,0,0,39.947,0H0V39.948a39.948,39.948,0,1,0,79.9,0Z"
                  fill="#D41717" fill-rule="evenodd"/>
        </g>

        <text x="100" y="62" font-family="'Inter', 'Segoe UI', sans-serif" font-size="46"
              font-weight="800" letter-spacing="-1">
            <tspan fill="#ffffff">Evil</tspan><tspan fill={`url(#${bannerGradientId})`}>Bounce</tspan>
        </text>
    </svg>

    <div class="divider"></div>

    <div class="message">
        <div>Thank you for <span>{anniversary} Years</span></div>
        <div>of EvilBounce!</div>
    </div>
</div>

<style>
    .animated-logo {
        display: flex;
        column-gap: 30px;
    }

    .logo-svg {
        display: block;
        width: 261.263px;
        height: 98px;
        flex: 0 0 auto;
        overflow: visible;
    }

    .divider {
        background-color: white;
        width: 2px;
        flex: 1;
    }

    .message {
        color: white;
        font-size: 25px;
        font-weight: 500;
        line-height: 40px;
        justify-content: center;
        display: flex;
        flex-direction: column;

        span {
            color: #EFBF04;
            font-weight: 600;
        }
    }

    .mark {
        filter: drop-shadow(0 0 16px rgba(212, 23, 23, 0.45)) drop-shadow(0 0 30px rgba(252, 65, 48, 0.25));
    }
</style>
