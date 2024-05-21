/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{ts,tsx}"],
  theme: {
    extend: {
      colors: {
        mainColor: "#050320",
        mainLightColor: "#214298"
      }
    },
  },
  plugins: [],
};
